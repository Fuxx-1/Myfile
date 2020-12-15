num = int(input())
ans = 0
while num > 0 :
    fact = 1
    for i in range(1, num + 1):
        fact = fact * i
    ans += fact
    num = num - 1
print(ans)
