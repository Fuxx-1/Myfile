import math

if __name__ == '__main__':
    try:
        n = float(input())
        while n:
            area = (1 / 2) * n * n * math.sin(math.pi / 3)
            area = round(area, 2)
            print(area)
            n = float(input())
    except EOFError:
        pass
