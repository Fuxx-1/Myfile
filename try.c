#include <stdio.h>
int main(int argc, char const* argv[])
{
#ifdef __linux__
    puts("It is in Linux OS!");
#endif
#ifdef __WINDOWS_
    puts("It is in Windows OS!");
#endif
#ifdef _WIN32
    puts("It is in Windows32 OS!");
#endif
    return 0;
}
