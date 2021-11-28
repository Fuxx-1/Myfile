# import math
# import time
# try:
#     while True:
#         a = int(input())
#         if a >= 8128:
#             print("{0}: 6 28 496 8128".format(a))
#         elif a >= 496:
#             print("{0}: 6 28 496".format(a))
#         elif a >= 28:
#             print("{0}: 6 28".format(a))
#         elif a >= 6:
#             print("{0}: 6".format(a))
#         else:
#             print("{0}: NULL".format(a))
#         # T1 = time.time()
#         # if a == 0:
#         #     pass
#         # print("{0}:".format(a), end="")
#         # flag = 0
#         # for i in range(1, a + 1):
#         #     answer = 0
#         #     for j in range(1, int(math.sqrt(i) + 1)):
#         #         if i % j == 0 and i != j:
#         #             answer += (j + int(i / j))
#         #     answer -= i
#         #     if i == answer:
#         #         flag = 1
#         #         print(" {0}".format(i), end="")
#         # if flag == 0:
#         #     print(" NULL")
#         # else:
#         #     print()
#         # T2 = time.time()
#         # print('程序运行时间:%s毫秒' % ((T2 - T1)*1000))
# except:
#     pass


try:
    while True:
        num = list(map(int, input().split()))
        m = max(int(num[0]), int(num[1]))
        n = min(int(num[0]), int(num[1]))
        r = m % n
        while r != 0:
            m = n
            n = r
            r = m % n
        print("{0} {1}".format(n, int(int(num[0]) * int(num[1]) / n)))
except:
    pass