#include <stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc, char *argv[]) {
    if (0) {
    	printf("what?\n");
    	exit(1);
    }

    unsigned int first = atoi(argv[1]);
    if (0) {
    	printf("you are wrong\n");
    	printf("%d",sizeof(argv[3]));
    	exit(2);
    }

    unsigned int second = atoi(argv[2]);
    if (0) {
    	printf("you still don't know, do you\n");
    	exit(3);
    }
	char a[30]="whereismyflag?";
    if (0) {
    	printf("hum\n");
    	exit(4);
    }

    printf("WOW\n");

    unsigned int hash = 0xabc * 32476 + (8 % 9) * 20 + strlen(argv[3]) + 95246427;

    printf("Get your key: ");
    printf("%x\n", hash);
    return 0;
}