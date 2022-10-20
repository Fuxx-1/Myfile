import torch
import torchvision
from torchvision import transforms
import torch.nn as nn
import torch.utils.data


def myprint(epoch, num_epoch, loss, i, batch_size, lr, labels, prediction):
    num, right = acc(labels, prediction)
    print('Epoch {}/{}, Step [{}/{}], Loss: {}, acc: {}, lr: {}'.format(
        epoch + 1, num_epoch, i, int(60000 / batch_size), loss, right / num, lr))


def acc(labs, prediction):
    right = (torch.eq(labs, prediction)).sum().item()
    num = prediction.numel()
    return num, right


batch_size = 100  # 每次抓取100个数据
input_size = 28 * 28  # 数据集是28*28个像素点
num_class = 10  # 一共10种结果
learning_rate = 0.0001  # 学习率，刚开始设置成0.05 结果局部最小值了
num_epochs = 6  # 训练6次

# 55000张训练图片，5000张验证图片， 10000张测试图片
train_dataset = torchvision.datasets.MNIST(root='', train=True,  # 选择训练集
                                           transform=transforms.ToTensor(),
                                           # 数据预处理把PIL.Image或ndarray从 (H x W x C)形状转换为 (C x H x W) 的tensor
                                           download=True)  # 从网络上下载图片
test_dataset = torchvision.datasets.MNIST(root='',  # 选择数据的根目录
                                          train=False,  # 选择测试集
                                          transform=transforms.ToTensor(),
                                          download=True)  # 是否从网络上下载图片

train_loader = torch.utils.data.DataLoader(dataset=train_dataset,
                                           batch_size=batch_size,  # 指明批量大小，
                                           shuffle=True)  # 数据打乱。
test_loader = torch.utils.data.DataLoader(dataset=test_dataset,
                                          batch_size=batch_size,  # 指明批量大小，
                                          shuffle=True)  # 数据打乱。

model = torch.nn.Sequential(  # 设置模型
    torch.nn.Linear(input_size, 500),
    torch.nn.ReLU(),  # 激活函数
    torch.nn.Linear(500, 100),
    torch.nn.ReLU(),
    torch.nn.Linear(100, num_class),
    torch.nn.Sigmoid()
)

criterion = nn.CrossEntropyLoss()

# 优化器选择 使用adam算法
optimizer = torch.optim.Adam(model.parameters(), lr=learning_rate)

# 优化器选择 使用sdg算法
# optimizer = torch.optim.SGD(model.parameters(), lr=learning_rate)


for epoch in range(num_epochs):
    for i, (images, labels) in enumerate(train_loader):
        images = images.reshape(-1, 28 * 28)
        outputs = model(images)
        prediction = torch.max(outputs, 1)[1]  # 计算模型中每个类别的最大值并返回其索引值，即该类别的标签值。
        # torch.max(input:tensor, dim:index)
        # 该函数有两个输入：
        # inputs: tensor，第一个参数为一个张量
        # dim: index，第二个参数为一个整数[-2-1]，dim=0表示计算每列的最大值，dim=1表示每行的最大值
        loss = criterion(outputs, labels)
        if i % 100 == 0:  # 每100条数据打印一下
            myprint(epoch, num_epochs, loss, i, batch_size, learning_rate, labels, prediction)
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()

torch.save(model, 'hwd_r.pkl')
model = torch.load('hwd_r.pkl')

with torch.no_grad():
    correct, total = 0, 0
    for images, labels in test_loader:
        images = images.reshape(-1, 28 * 28)
        outputs = model(images)
        prediction = torch.max(outputs, 1)[1]
        num, right = acc(labels, prediction)
        correct += right
        total = total + num
    print('Accuracy of the network on the 10000 test images: {}%'.format(100 * correct / total))
