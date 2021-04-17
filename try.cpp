#include <stdio.h>
int main(void) {
    char s[] = "mydoghasabook";
    char key = 'o';
    int i = 0, j = 0;
    for (; !(s[i] - key) || (s[j++] = s[i]); i++) {}
    puts(s);
    return 0;
}