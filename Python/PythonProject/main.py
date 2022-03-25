# # 这是一个示例 Python 脚本。
#
# # 按 Shift+F10 执行或将其替换为您的代码。
# # 按 双击 Shift 在所有地方搜索类、文件、工具窗口、操作和设置。
#
#
# def print_hi(name):
#     # 在下面的代码行中使用断点来调试脚本。
#     print(f'Hi, {name}')  # 按 Ctrl+F8 切换断点。
#
#
# # 按间距中的绿色按钮以运行脚本。
# if __name__ == '__main__':
#     print_hi('PyCharm')
#
# # 访问 https://www.jetbrains.com/help/pycharm/ 获取 PyCharm 帮助

# a = input()
# a = input().split()
# sum = 0
# min = 101
# max = -1
# fail = 0
# for i in range(0, len(a)):
#     if int(a[i]) > max:
#         max = int(a[i])
#     if min > int(a[i]):
#         min = int(a[i])
#     if int(a[i]) < 60:
#         fail += 1
#     sum += int(a[i])
# print("Max: {}\nMin: {}\nAve: {}\nFail: {}".format(max, min, sum / len(a), fail))

# s = input().split()
# a = float(s[0])
# b = float(s[1])
# fee = a * b
# if b < 250:
#     fee *= 1
# elif 250 <= b < 500:
#     fee *= 0.98
# elif b < 1000:
#     fee *= 0.95
# elif b < 2000:
#     fee *= 0.92
# elif b < 3000:
#     fee *= 0.9
# elif b > 3000:
#     fee *= 0.85
# print(int(fee))

s = input().split()
a = int(s[0])
b = int(s[1])
for i in range(1, a + 1):
    if i % b == 0
