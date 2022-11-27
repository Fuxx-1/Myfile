import random
from utils import dist

import numpy as np


class DBSCAN:
    def __init__(self, eps, minpts):
        self.eps = eps
        self.minPts = minpts

    def start(self, data):
        num = len(data)
        unvisited = [i for i in range(num)]  # 还未访问的点
        visited = []  # 已经访问的点
        C = [-1 for i in range(num)]  # 输出结果
        # 用k来标记不同的簇，k = -1表示噪声点
        k = -1
        # 如果还有未访问到的点
        while len(unvisited) > 0:
            # 随机选取一个未访问的点
            cur = random.choice(unvisited)
            unvisited.remove(cur)
            visited.append(cur)

            N = []  # N为cur的eps领域中对象集合
            for u in range(num):
                if dist(data[u], data[cur]) <= self.eps:
                    N.append(u)

            # 如果cur的eps领域中对象数大于minpts,说明cur是一个核心点
            if len(N) >= self.minPts:
                k = k + 1
                C[cur] = k

                for pi in N:
                    if pi in unvisited:
                        unvisited.remove(pi)
                        visited.append(pi)
                        # 继续蔓延
                        M = []  # M是位于pi的邻域中的点的列表
                        for j in range(num):
                            if dist(data[j], data[pi]) <= self.eps:
                                M.append(j)
                        if len(M) >= self.minPts:
                            for t in M:
                                if t not in N:
                                    N.append(t)

                # 若pi不属于任何簇，C[pi] == -1说明C中第pi个值没有改动
                    if C[pi] == -1:
                        C[pi] = k

            else:
                C[cur] = -1
        return C
