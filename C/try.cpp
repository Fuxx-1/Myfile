#include <stdio.h>

int price[1000];
int require[1000];
int sale[10][1000];
int contrast[1000];
int dp[1000][1000];

int count(int a[], int b[], int c[])
{
    for (int i = 1; i < 1000; i++) {
        if (a[i] - b[i] < c[i]) {
            return 0;   
        }
    }
    return 1;
}

int main()
{
    // 输入及预处理部分
    int row = 0, total = 0, totalRequire = 0;
    scanf("%d", &row);
    for (int i = 0; i < row; i++) {
        int id, tempRequire, tempPrice;
        scanf("%d %d %d", &id, &tempRequire, &tempPrice);
        require[id] = tempRequire;
        price[id] = tempPrice;
        totalRequire += tempRequire;
        total += tempRequire * tempPrice;
    }
    scanf("%d", &row);
    for (int i = 0; i < row; i++) {
        int times = 0, temp2 = 0, temp = 0;
        scanf("%d", &times);
        for (int j = 0; j < times; j++) {
            int id, tempRequire;
            scanf("%d %d", &id, &tempRequire);
            sale[i][id] = tempRequire;
            temp += tempRequire * price[id];
        }
        scanf("%d", &temp2);
        sale[i][0] = temp - temp2;
    }
    printf("%d\n", total);
    // 计算最大优惠
    for (int i = 0; i < totalRequire; i++) {
        // 增加
        for (int j = 1; j < 1000; j++) {
            dp[i][j] = dp[i - 1][j];
            if (dp[i][j] < require[j]) {
                dp[i][j]++;
                break;
            }
        }
        int max = 0;
        // 计算最优方案
        for (int j = 0; j < row; j++) {
            // 遍历所有方案
            int temp = 0;
            if (count(dp[i], contrast, sale[j])) {
                temp = sale[j][0];
                int temp2 = i;
                while (--temp2 >= 0) {
                    if (count(dp[i], dp[temp2], sale[j])) {
                        temp = dp[temp2][0] + sale[j][0];
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
                if (temp > max) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }
        dp[i][0] = max;
    }
    printf("%d", total - dp[totalRequire - 1][0]);
    return 0;
}
