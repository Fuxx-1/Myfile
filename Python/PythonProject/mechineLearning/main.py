from sklearn import datasets
import utils
import numpy as np
from DBSCAN import DBSCAN

iris = datasets.load_iris()
iris_x = iris.data  # 150*4
iris_y = iris.target

dbscan = DBSCAN(1, 30)
res = dbscan.start(iris_x)


for i in range(len(res)):
    print(res[i], end=' ')
    if (i+1) % 40 == 0:
        print(end='\n')

print(end='\n')
iris_y = iris_y.tolist()
for i in range(len(iris_y)):
    print(iris_y[i], end=' ')
    if (i+1) % 40 == 0:
        print(end='\n')
