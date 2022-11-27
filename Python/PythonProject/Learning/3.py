def dbscan(Data, Eps, MinPts):
    num = len(Data)  # 点的个数
    unvisited = [i for i in range(num)]  # 没有访问到的点的列表
    visited = []  # 已经访问的点的列表
    C = [-1 for i in range(num)]
    k = -1
    while len(unvisited) > 0:
        p = random.choice(unvisited)
        unvisited.remove(p)
        visited.append(p)
        N = []
        for i in range(num):
            if (dist(Data[i], Data[p]) <= Eps):# and (i!=p):
                N.append(i)
        if len(N) >= MinPts:
            k = k+1
            C[p] = k
            for pi in N:
                if pi in unvisited:
                    unvisited.remove(pi)
                    visited.append(pi)
                    M = []
                    for j in range(num):
                        if (dist(Data[j], Data[pi])<=Eps): #and (j!=pi):
                            M.append(j)
                    if len(M)>=MinPts:
                        for t in M:
                            if t not in N:
                                N.append(t)
                if C[pi] == -1:
                    C[pi] = k
        else:
            C[p] = -1
    return C

