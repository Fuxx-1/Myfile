#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    for (int i = n; i <= 2 * n - 1; i++) {
        cout << i << endl;
    }
    return 0;
}