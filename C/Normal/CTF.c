#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[]) {


    printf("WOW\n");

    unsigned int hash = 0xabc * 32476 + (8 % 9) * 20 + strlen(argv[3]) + 95246427;

    printf("Get your key: ");
    printf("%x\n", hash);
    return 0;
}