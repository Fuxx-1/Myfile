#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    system("DIR *.in  /B > SourceTemp");
    remove("./SourceTemp");
    return 0;
}
