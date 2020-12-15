import math
n = int(input())
ans = 0
while n >= 0:
    ans += math.floor(n / 5)
    n -= 1
print(math.floor(ans))
