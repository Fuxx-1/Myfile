import numpy as np
import pandas as pd
import torch
from matplotlib import pyplot as plt
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import label_binarize


def readData():
    x = load_iris()['data']
    y = load_iris()['target']

    x_train, x_test, y_train, y_test = train_test_split(torch.FloatTensor(x), y, test_size=0.2)

    return x_train, x_test, y_train, y_test


def NN_iris():
    x_train, x_test, y_train, y_test = readData()

    net = torch.nn.Sequential(
        torch.nn.Linear(4, 20),
        torch.nn.Sigmoid(),
        # torch.nn.Linear(20, 10),
        # torch.nn.Sigmoid(),
        torch.nn.Linear(20, 3),
    )

    optimizer = torch.optim.SGD(net.parameters(), lr=0.05)
    loss_func = torch.nn.CrossEntropyLoss()

    y_train = torch.FloatTensor(label_binarize(y_train, classes=[0, 1, 2]))
    for t in range(500):
        out = net(x_train)
        loss = loss_func(out, y_train)
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()

    out = net(x_test)
    prediction = torch.max(out, 1)[1]
    pred_y = prediction.data.numpy()
    print(out)
    accuracy = float((pred_y == y_test).astype(int).sum()) / float(y_test.size)
    print("鸢尾花预测准确率:", accuracy)

    cm = np.zeros([4, 4], float)
    for i in range(y_test.size):
        cm[y_test[i], pred_y[i]] += 1
    for i in range(3):
        cm[3, i] = cm[..., i].sum()
    for i in range(4):
        cm[i, 3] = cm[i, ...].sum()

    P = np.zeros([1, 3], float)
    R = np.zeros([1, 3], float)

    for i in range(3):
        P[0, i] = cm[i, i] / cm[3, i]
    for i in range(3):
        R[0, i] = cm[i, i] / cm[i, 3]

    print(cm)
    print(P)
    print(R)
    print(y_test)
    print(pred_y)


NN_iris()

