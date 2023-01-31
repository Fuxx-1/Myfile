#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <WS2tcpip.h>
#include <winsock2.h>
#include <windows.h>
#define _BSD_SOURCE
// #include <ws2tcpip.h>
// #pragma comment(lib, "ws2_32.lib") 

#define BUFSIZE 10240
#define STRSIZE 1024
#define FILE_NAME "PC2_Ethernet0_to_R3_FastEthernet00.pcap"
#define FORWARD_TTLERROR 0 // TTL为0
#define FORWARD_DIRECT_DELIVERY 1 // Direct delivery直接交付
#define FORWARD_INDIRECT_DELIVERY 2 // Indirect delivery间接交付
#define FORWARD_NOROUTE 3 //

typedef int bpf_int32;
typedef unsigned int bpf_u_int32;
typedef unsigned short u_short;
typedef unsigned int u_int32;
typedef unsigned short u_int16;
typedef unsigned char u_int8;

typedef struct route_msg {
    char dest[STRSIZE]; // 目的网络
    char mask[STRSIZE]; // 掩码
    unsigned int masklen; // 掩码长度
    char nexthop[STRSIZE]; // 下一跳
} route_msg;

// pacp文件头结构体

struct pcap_file_header {
    bpf_u_int32 magic; /* 0xa1b2c3d4 */
    u_short version_major; /* magjor Version 2 */
    u_short version_minor; /* magjor Version 4 */
    bpf_int32 thiszone; /* gmt to local correction */
    bpf_u_int32 sigfigs; /* accuracy of timestamps */
    bpf_u_int32 snaplen; /* max length saved portion of each pkt */
    bpf_u_int32 linktype; /* data link type (LINKTYPE_*) */
};

// 时间戳
struct time_val {
    int tv_sec; /* seconds 含义同 time_t 对象的值 */
    int tv_usec; /* and microseconds */
};

// pcap数据包头结构体
struct pcap_pkthdr {
    struct time_val ts; /* time stamp */
    bpf_u_int32 caplen; /* length of portion present */
    bpf_u_int32 len; /* length this packet (off wire) */
};

// 数据帧头
typedef struct FramHeader_t { // Pcap捕获的数据帧头
    u_int8 DstMAC[6]; // 目的MAC地址
    u_int8 SrcMAC[6]; // 源MAC地址
    u_short FrameType; // 帧类型
} FramHeader_t;

// IP数据报头
typedef struct IPHeader_t { // IP数据报头
    u_int8 Ver_HLen; // 版本+报头长度
    u_int8 TOS; // 服务类型
    u_int16 TotalLen; // 总长度
    u_int16 ID; // 标识
    u_int16 Flag_Segment; // 标志+片偏移
    u_int8 TTL; // 生存周期
    u_int8 Protocol; // 协议类型
    u_int16 Checksum; // 头部校验和
    u_int32 SrcIP; // 源IP地址
    u_int32 DstIP; // 目的IP地址
} IPHeader_t;

typedef struct IP_Link {
    IPHeader_t* IP_Data;
    struct IP_Link* next;
} IP_Link;

/* Structs End */

int masklen;
char dest[100], nexthop[100];
char buf[1024];
static route_msg route_table[100];
static int table_size = 0;

const char *inet_ntop(int af, const void *src, char *dst, socklen_t size);
int inet_pton(int af, const char *src, void *dst);
void route_Init();
void route_add(route_msg* proute);
int stud_fwd_deal(IPHeader_t* pBufferm, int number, char* my_time);
int fwd_DiscardPkt(IPHeader_t* pBuffer, int type, int number, char* my_time, char* next_Hop);
int read_pcap(char* pcapname);
char* getMask(int masklen);
int read_Route(char* routeName);

int main(int argc, char const* argv[])
{
    char routeName[100];
    char pcapname[100];

    printf("请输入路由表路径: ");
    scanf("%s", routeName);
    printf("请输入PCAP文件路径: ");
    scanf("%s", pcapname);
    printf("路由表路径: %s \nPCAP文件路径: %s", routeName, pcapname);

    // /run/media/eleun/Fuxx/Programing/Myfile/C/RIP_Simulation/route.txt
    // /run/media/eleun/Fuxx/Programing/Myfile/C/RIP_Simulation/R3_FastEthernet01_to_R2_FastEthernet00.pcap

    read_Route(routeName);
    printf("[DEBUG]ReadRoute Over!\n");
    read_pcap(pcapname);
    printf("[DEBUG]ReadPCAP Over!\n");

    return 0;
}

char* getMask(int masklen)
{
    static char mask[1024];
    if (masklen == 32) {
        strcpy(mask, "255.255.255.255");
        return mask;
    } else if (masklen == 24) {
        strcpy(mask, "255.255.255.0");
        return mask;
    } else if (masklen == 16) {
        strcpy(mask, "255.255.0.0");
        return mask;
    } else if (masklen == 8) {
        strcpy(mask, "255.0.0.0");
        return mask;
    } else if (masklen == 0) {
        strcpy(mask, "0.0.0.0");
        return mask;
    }

    strcpy(mask, "掩码长度不是0,8,16,24,32之一");
    return mask;
}

int read_Route(char* routeName)
{
    FILE* fp1 = fopen(routeName, "r");
    // FILE *fp2 = fopen("route_table","a");
    if (fp1 == NULL) {
        puts("不能打开文件！");
        return 0;
    }
    /*
            while(!feof(fp1)){
                    fscanf(fp1,"%s",c);
                    printf("%s\n",c);

            }
    */

    int len;
    while (fgets(buf, 1024, fp1) != NULL) {
        len = strlen(buf);
        buf[len - 1] = '\0';

        // 判断路由表前缀为Ｃ、Ｌ的

        if (buf[0] == 'C' || buf[0] == 'L') {
            printf("%s\n", buf);
            char* p = strtok(buf, " ");
            while (p = strtok(NULL, " ")) {
                sscanf(p, "%[0-9.]/%d", dest, &masklen);
            }
            printf("dest：%s,masklen:%d\n", dest, masklen);
            if (dest != NULL) {
                struct route_msg* msg;
                msg = (struct route_msg*)malloc(sizeof(struct route_msg));
                strcpy(msg->dest, dest);
                strcpy(msg->mask, getMask(masklen));
                msg->masklen = masklen;
                strcpy(msg->nexthop, "直接交付");
                route_add(msg);
                printf("msg->dest:%s,msg->mask:%s,msg->masklen:%d,msg->nexthop:%s", msg->dest, msg->mask, msg->masklen, msg->nexthop);
            }

        } else if (buf[0] == 'S') {
            printf("%s\n", buf);
            char temp1[1024], temp2[1024], temp3[1024];
            sscanf(buf, "%s %[0-9.]/%d %s %s %[0-9.]", temp1, dest, &masklen, temp2, temp3, nexthop);
            printf("temp1:%s,dest:%s,masklen:%d,temp2:%s,nexthop:%s\n", temp1, dest, masklen, temp2, nexthop);
            if (nexthop != NULL) {
                struct route_msg* msg;
                msg = (struct route_msg*)malloc(sizeof(struct route_msg));
                strcpy(msg->dest, dest);
                strcpy(msg->mask, getMask(masklen));
                msg->masklen = masklen;
                strcpy(msg->nexthop, nexthop);
                route_add(msg);
                printf("msg->dest:%s,msg->mask:%s,msg->masklen:%d,msg->nexthop:%s", msg->dest, msg->mask, msg->masklen, msg->nexthop);
            }
        }
    }
    printf("\n");
    fclose(fp1);
    return 1;
}

int read_pcap(char* pcapname)
{
    struct pcap_pkthdr* ptk_header;
    FramHeader_t* mac_header;
    IPHeader_t* ip_header;
    IP_Link *head, *data;

    FILE* fp;
    int pkt_offset, i = 0;
    int ip_len, ip_proto;

    char my_time[STRSIZE];
    char src_ip[STRSIZE], dst_ip[STRSIZE];
    int verLen, ttl;

    // 初始化
    ptk_header = (struct pcap_pkthdr*)malloc(sizeof(struct pcap_pkthdr));
    mac_header = (FramHeader_t*)malloc(sizeof(FramHeader_t));
    ip_header = (IPHeader_t*)malloc(sizeof(IPHeader_t));
    head = (struct IP_Link*)malloc(sizeof(IP_Link));
    data = (struct IP_Link*)malloc(sizeof(IP_Link));

    if ((fp = fopen(pcapname, "r")) == NULL) {
        printf("error: can not open pcap file\n");
        exit(0);
    }

    // 开始读数据包
    pkt_offset = 24; // pcap文件头结构 24个字节

    head->next = data;
    while (fseek(fp, pkt_offset, SEEK_SET) == 0) // 遍历数据包
    {
        i++;
        // pcap_pkt_header 16 byte
        memset(ptk_header, 0, sizeof(struct pcap_pkthdr));
        if (fread(ptk_header, 16, 1, fp) != 1) // 读pcap数据包头结构
        {
            printf("\nread end of pcap file\n");
            break;
        }

        pkt_offset += 16 + ptk_header->caplen; // 下一个数据包的偏移值

        // 读取pcap包时间戳，转换成标准格式时间
        struct tm* timeinfo;
        time_t t = (time_t)(ptk_header->ts.tv_sec);
        timeinfo = localtime(&t);

        strftime(my_time, sizeof(my_time), "%Y-%m-%d %H:%M:%S", timeinfo); // 获取时间
        // printf("%s\n", my_time);

        // 数据帧头 14字节
        fseek(fp, 14, SEEK_CUR); // 忽略数据帧头

        // IP数据报头 20字节
        memset(ip_header, 0, sizeof(IPHeader_t));

        if (fread(ip_header, sizeof(IPHeader_t), 1, fp) != 1) {
            printf("%d: can not read ip_header\n\n", i);
            break;
        }

        printf("DstIP:%d\n", ip_header->DstIP);
        inet_ntop(AF_INET, (void*)&(ip_header->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(ip_header->DstIP), dst_ip, 16);

        stud_fwd_deal(ip_header, i, my_time);

        ip_proto = ip_header->Protocol;
        verLen = (int)(((ip_header->Ver_HLen) & 0xf0) >> 4);
        ttl = (int)ip_header->TTL;

        printf("第%d个IP数据包, verLen:%d, TTL:%d, ", i, verLen, ttl);
        printf("time:%s, src_ip:%s, dst_ip:%s, ip protocol:%d\n", my_time, src_ip, dst_ip, ip_proto);
        unsigned int address;
        inet_pton(AF_INET, src_ip, &address);

        printf("src_ip:%s,SrcIP：%d\n", src_ip, address);

        printf("\n");
        ip_len = ip_header->TotalLen; // IP数据报总长度

    } // end while

    fclose(fp);

    // free(file_header);
    free(ptk_header);
    free(ip_header);
    return 1;
}

void route_Init()
{
}

void route_add(route_msg* proute)
{

    strcpy(route_table[table_size].dest, proute->dest);

    strcpy(route_table[table_size].mask, proute->mask);

    route_table[table_size].masklen = proute->masklen;

    strcpy(route_table[table_size].nexthop, proute->nexthop);

    table_size++;
}
/*
void route_input(){

        int flag = 1;
        while(1)
        {
                printf("\n输入1增加路由表，输入其他字符退出增加路由表:");
                scanf("%d",&flag);
                printf("%d",flag);
                if(flag == 1){
                        struct route_msg *msg;
                        msg = (struct route_msg *)malloc(sizeof(struct route_msg));
                        printf("\n请输入路由表项的目的网络(例：192.168.10.0)：");
                        scanf("%s",msg->dest);
                        printf("destStr:%s",msg->dest);

                        printf("\n请输入路由表项的掩码(例：255.255.255.255)：");
                        scanf("%s",msg->mask);
                        printf("destStr:%s",msg->mask);

                        printf("\n请输入路由表项的掩码长度(范围：0~32)：");
                        scanf("%d",&(msg->masklen));
                        printf("masklenStr:%d",msg->masklen);

                        printf("\n请输入路由表项的下一跳（路由器本机地址，输入: 直接交付，否者输入下一跳地址）：");
                        scanf("%s",msg->nexthop);
                        printf("nexthopStr:%s",msg->nexthop);

                        route_add(msg);

                } else if(flag != 1) {
                        break;
                }
        }


}
*/

int fwd_DiscardPkt(IPHeader_t* pBuffer, int type, int number, char* my_time, char* next_Hop)
{
    FILE* fp = NULL;
    char *filename0 = NULL, *filename1 = NULL, *filename2 = NULL;
    char *filename3 = NULL, *filenameD = NULL;

    char src_ip[STRSIZE], dst_ip[STRSIZE];
    int verLen, ttl;

    // 时间戳
    struct tm* newtime;
    char outfile[128];
    time_t t1;
    time(&t1);
    newtime = localtime(&t1);
    strftime(outfile, 128, "%Y-%m-%d %H:%M:%S.txt", newtime);
    // printf("outfile:%s\n", outfile);

    char file0[20] = "TTL_error_";
    char file1[20] = "Direct_";
    char file2[20] = "Indirect_";
    char file3[20] = "Noroute_";
    char fileD[20] = "Default_";

    filename0 = (char*)malloc(strlen(file0) + strlen(outfile));
    sprintf(filename0, "%s%s", file0, outfile);
    // printf("filename0: %s\n",filename0);

    filename1 = (char*)malloc(strlen(file1) + strlen(outfile));
    sprintf(filename1, "%s%s", file1, outfile);
    // printf("filename1: %s\n",filename1);

    filename2 = (char*)malloc(strlen(file2) + strlen(outfile));
    sprintf(filename2, "%s%s", file2, outfile);
    // printf("filename2: %s\n",filename2);

    filename3 = (char*)malloc(strlen(file3) + strlen(outfile));
    sprintf(filename3, "%s%s", file3, outfile);
    // printf("filename3: %s\n",filename3);

    filenameD = (char*)malloc(strlen(fileD) + strlen(outfile));
    sprintf(filenameD, "%s%s", fileD, outfile);
    // printf("filenameD: %s\n",filenameD);

    if (type == 0) {
        fp = fopen(filename0, "a+");
        printf("%s\n", filename0);
        verLen = (int)(((pBuffer->Ver_HLen) & 0xf0) >> 4);

        ttl = (int)pBuffer->TTL;

        inet_ntop(AF_INET, (void*)&(pBuffer->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(pBuffer->DstIP), dst_ip, 16);

        fprintf(fp, "number:%d\t\t源地址：%s\t\t目的地址：%s\t\tTTL:%d\n", number, src_ip, dst_ip, ttl);

        // fwrite(pBuffer, sizeof(struct IPHeader_t), 1, fp);
    } else if (type == 1) {
        fp = fopen(filename1, "a+");
        printf("%s\n", filename1);
        verLen = (int)(((pBuffer->Ver_HLen) & 0xf0) >> 4);

        ttl = (int)pBuffer->TTL;

        inet_ntop(AF_INET, (void*)&(pBuffer->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(pBuffer->DstIP), dst_ip, 16);

        fprintf(fp, "number:%d\t\tTIME:%s\t\t源地址：%s\t\t目的地址：%s\t\t下一跳：%s\t\tTTL:%d\n", number, my_time, src_ip, dst_ip, next_Hop, ttl);
        // fwrite(pBuffer, sizeof(struct IPHeader_t), 1, fp);
    } else if (type == 2) {
        fp = fopen(filename2, "a+");
        printf("%s\n", filename2);
        verLen = (int)(((pBuffer->Ver_HLen) & 0xf0) >> 4);

        ttl = (int)pBuffer->TTL;

        inet_ntop(AF_INET, (void*)&(pBuffer->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(pBuffer->DstIP), dst_ip, 16);

        fprintf(fp, "number:%d\t\tTIME:%s\t\t源地址：%s\t\t目的地址：%s\t\t下一跳：%s\t\tTTL:%d\n", number, my_time, src_ip, dst_ip, next_Hop, ttl);
        // fwrite(pBuffer, sizeof(struct IPHeader_t), 1, fp);
    } else if (type == 3) {
        fp = fopen(filename3, "a+");
        printf("%s\n", filename3);
        verLen = (int)(((pBuffer->Ver_HLen) & 0xf0) >> 4);

        ttl = (int)pBuffer->TTL;

        inet_ntop(AF_INET, (void*)&(pBuffer->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(pBuffer->DstIP), dst_ip, 16);

        fprintf(fp, "number:%d\t\tTIME:%s\t\t源地址：%s\t\t目的地址：%s\t\tTTL:%d\n", number, my_time, src_ip, dst_ip, ttl);
        // fwrite(pBuffer, sizeof(struct IPHeader_t), 1, fp);
    } else {
        fp = fopen(filenameD, "a+");
        printf("%s\n", filenameD);
        verLen = (int)(((pBuffer->Ver_HLen) & 0xf0) >> 4);

        ttl = (int)pBuffer->TTL;

        inet_ntop(AF_INET, (void*)&(pBuffer->SrcIP), src_ip, 16);

        inet_ntop(AF_INET, (void*)&(pBuffer->DstIP), dst_ip, 16);

        fprintf(fp, "number:%d\t\tTIME:%s\t\t源地址：%s\t\t目的地址：%s\t\tTTL:%d\n", number, my_time, src_ip, dst_ip, ttl);

        // fwrite(pBuffer, sizeof(struct IPHeader_t), 1, fp);
    }

    fclose(fp);
    return 1;
}

// 查找路由表,确定下一步处理流程(丢弃/处理/转发)
int stud_fwd_deal(IPHeader_t* pBuffer, int number, char* my_time)
{
    // 获取目的地址，ttl,校验和
    unsigned int dest_address = pBuffer->DstIP;
    unsigned int ttl = (int)pBuffer->TTL;

    unsigned int IPAddress, maskAddress;

    // 检验TTL，如果为0则丢弃：
    if (ttl <= 0) {
        printf("TTL error 数据包丢弃！\n");
        fwd_DiscardPkt(pBuffer, FORWARD_TTLERROR, number, my_time, NULL);
        return 1;
    }

    int i;
    // 如果目的地址是本机，接收
    // 查找路由表，下一跳为直接交付
    for (i = 0; i < table_size; i++) {
        /*
                        char destAddress[STRSIZE];
                        unsigned int address;
                        printf("dest:%s\n",route_table[i].dest);
                        strcpy(destAddress, route_table[i].dest);

                        inet_pton(AF_INET,destAddress,&address);
                        printf("dest_address:%d,address:%d\n",dest_address,address);
        */

        // 对传入的IP数据包的目的地址与路由表的掩码做与操作得出目的网络，在路由表里遍历
        printf("路由表第%d个： dest:%s,nexthop:%s\n", i, route_table[i].dest, route_table[i].nexthop);

        inet_pton(AF_INET, route_table[i].dest, &IPAddress);
        inet_pton(AF_INET, route_table[i].mask, &maskAddress);

        char string[1024] = "直接交付";
        if ((strcmp(route_table[i].nexthop, string) == 0) && IPAddress == (dest_address & maskAddress)) {
            printf("直接交付\n");
            fwd_DiscardPkt(pBuffer, FORWARD_DIRECT_DELIVERY, number, my_time, route_table[i].nexthop);
            return 0;
        }
    }
    unsigned int max_masklen = 0;
    char nexthop[STRSIZE];

    //    如果目的地址不是本机
    //    按照最长匹配查找路由表获取下一跳

    for (i = 0; i < table_size; i++) {
        unsigned int masklen = route_table[i].masklen;

        inet_pton(AF_INET, route_table[i].dest, &IPAddress);
        inet_pton(AF_INET, route_table[i].mask, &maskAddress);

        printf("IPAddress:%d,maskAddress:%d,dest_address & maskAddress:%d\n", IPAddress, maskAddress, (dest_address & maskAddress));

        if (route_table[i].masklen > max_masklen && IPAddress == (dest_address & maskAddress)) {
            max_masklen = masklen;
            strcpy(nexthop, route_table[i].nexthop);
            printf("route_table[table_size].nexthop:%s,nexthop:%s\n", route_table[i].nexthop, nexthop);
        }
    }

    // 查找失败
    if (max_masklen == 0) {
        printf("路由表内无路由\n");
        fwd_DiscardPkt(pBuffer, FORWARD_NOROUTE, number, my_time, NULL);
        return 1;
    }

    printf("间接发送，下一跳地址：%s\n", nexthop);
    fwd_DiscardPkt(pBuffer, FORWARD_INDIRECT_DELIVERY, number, my_time, nexthop);
    return 0;

    // 查找成功，设置ttl
    //    pBuffer->TTL = ttl - 1;
    // 计算校验和
    //    ((unsigned short *)pBuffer)[5] = 0;
    //    unsigned int sum = 0;
    //    for (i = 0; i < 10; i++)
    //    {
    //        sum += ntohs(pBuffer[i]);
    //        sum = (sum >> 16) + (sum & 0xffff);
    //    }
    //    ((unsigned short *)pBuffer)[5] = htons((~(unsigned short)sum));
    // 发送
    //    printf("发送\n");
}

const char *inet_ntop(int af, const void *src, char *dst, socklen_t size)
{
    struct sockaddr_in srcaddr;
 
    memset(&srcaddr, 0, sizeof(struct sockaddr_in));
    memcpy(&(srcaddr.sin_addr), src, sizeof(srcaddr.sin_addr));
 
    srcaddr.sin_family = af;
    if (WSAAddressToString((struct sockaddr *) &srcaddr, sizeof(struct sockaddr_in), 0, dst, (LPDWORD) &size) != 0) {
        DWORD rv = WSAGetLastError();
        printf("WSAAddressToString() : %d\n",rv);
        return NULL;
    }
    return dst;
}

int inet_pton(int af, const char *src, void *dst)
{
    struct sockaddr_in sa;
    int src_len = strlen(src);
    int result = WSAStringToAddressA((LPSTR)src, af, NULL, (LPSOCKADDR)&sa, &src_len);
    if (result != 0) {
        return 0;
    }
    memcpy(dst, &(sa.sin_addr), sizeof(struct in_addr));
    return 1;
}