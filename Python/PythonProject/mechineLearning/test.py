# use mnist to test environment
# -*- coding: utf-8 -*-
# 使用卷积神经网络训练mnist数据集

import gzip
from tensorflow.keras.datasets import mnist
from tensorflow.keras.utils import to_categorical
import tensorflow as tf
from tensorflow.keras.layers import Input, Dense, Conv2D, MaxPooling2D, Flatten, Reshape
import numpy as np
from sklearn.metrics import classification_report
import datetime

'''
# 装载数据集（从网上下载）
(train_images, train_labels), (test_images, test_labels) = mnist.load_data()
'''


# 装载数据集（本地导入）
def load_data():
    path = r"D:\Programing\Myfile\Python\PythonProject\CNN\MNIST_data\mnist.npz"
    f = np.load(path)
    train_images, train_labels = f['x_train'], f['y_train']
    test_images, test_labels = f['x_test'], f['y_test']
    f.close()
    return (train_images, train_labels), (test_images, test_labels)


def load_data1():
    path = "E:\\PythonProject\\CNN\\MNIST_data\\"
    files = [path + 'train-images-idx3-ubyte.gz', path + 'train-labels-idx1-ubyte.gz',
             path + 't10k-images-idx3-ubyte.gz', path + 't10k-labels-idx1-ubyte.gz']
    # print(file)
    with gzip.open(files[0], 'rb') as ip:
        # 6万张训练图片
        train_images = np.frombuffer(ip.read(), np.uint8, offset=16)
        train_images = train_images.reshape(60000, 28, 28)

    with gzip.open(files[1], 'rb') as lp:
        train_labels = np.frombuffer(lp.read(), np.uint8, offset=8)

    with gzip.open(files[2], 'rb') as ip2:
        # 1万张测试图片
        test_images = np.frombuffer(ip2.read(), np.uint8, offset=16)
        test_images = test_images.reshape(10000, 28, 28)

    with gzip.open(files[3], 'rb') as lp2:
        test_labels = np.frombuffer(lp2.read(), np.uint8, offset=8)

    # print(train_image)
    return (train_images, train_labels), (test_images, test_labels)


if __name__ == '__main__':
    # (train_images, train_labels), (test_images, test_labels) = load_data()
    # print(len(train_labels))
    (train_images, train_labels), (test_images, test_labels) = load_data1()
    print(len(train_labels))

    # 数据预处理
    train_images = train_images.reshape((len(train_images), 28, 28, 1))
    # 此处采用float32是权衡了时间何空间开销，float64精度高，但数据集会大大占用消耗的内存, 像素值映射到 0 - 1 之间
    train_images = train_images.astype('float32') / 255

    test_images = test_images.reshape((len(test_images), 28, 28, 1))
    test_images = test_images.astype('float32') / 255

    train_labels = to_categorical(train_labels)  # one-hot编码
    test_labels = to_categorical(test_labels)

    # 添加模型
    model1 = tf.keras.models.Sequential()

    # 第1层卷积，卷积核大小为3*3，32个，28*28为待训练图片的大小
    model1.add(Conv2D(32, (3, 3), activation='relu', input_shape=(28, 28, 1)))
    model1.add(MaxPooling2D((2, 2)))

    # 第2层卷积，卷积核大小为3*3，64个，激活函数relu
    model1.add(Conv2D(64, (3, 3), activation='relu'))
    model1.add(MaxPooling2D((2, 2)))

    # 第3层卷积，卷积核大小为3*3，64个
    model1.add(Conv2D(64, (3, 3), activation='relu'))

    # 添加分类器
    model1.add(Flatten())
    model1.add(Dense(64, activation='relu'))
    model1.add(Dense(10, activation='softmax'))

    # 模型编译
    model1.compile(optimizer='rmsprop', loss='categorical_crossentropy', metrics=['accuracy'])

    # 保存模型数据到.\results\tb_results\路径下
    log_dir = '.\\results\\tb_results\\' + datetime.datetime.now().strftime("%Y%m%d-%H%M%S")
    tensorboard_callback = tf.keras.callbacks.TensorBoard(log_dir=log_dir, histogram_freq=1)
    # 训练模型
    model1.fit(train_images, train_labels, epochs=5, batch_size=128, callbacks=([tensorboard_callback]))

    # 在测试集上对模型进行评估
    test_loss, test_acc = model1.evaluate(test_images, test_labels)
    print(test_loss, test_acc)
    # print(model1.summary())
