# import math
#
# if __name__ == '__main__':
#     try:
#         n = float(input())
#         while n:
#             area = (1 / 2) * n * n * math.sin(math.pi / 3)
#             area = round(area, 2)
#             print(area)
#             n = float(input())
#     except EOFError:
#         pass

m = int(input())
for i in range(m):
    n = int(input())
    s = [0] * n
    s = {0, 0, 0, 0}
    r = [0] * 4
    for j in range(int(n * (n - 1) / 2)):
        r = input().split()
        if r[2] > r[3]:
            s[r[0]] += 3
        elif r[2] > r[3]:
            s[r[1]] += 3
        else:
            s[r[0]] += 1
            s[r[1]] += 1
    for j in range(n):
        valtemp = 0
        for k in range(n):
            if a[k] > valtemp:
                team = k + 1
                valtemp = a[k]
        print("{0:} ".format(team))
