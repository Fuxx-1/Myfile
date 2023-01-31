from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.svm import SVC
from sklearn.model_selection import GridSearchCV
import matplotlib.pyplot as plt
from sklearn.metrics import accuracy_score

# 加载数据集
digits = datasets.load_digits()
X = digits.data
y = digits.target

# 将数据集分成训练集和测试集
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# 定义四种核函数
kernels = ['linear', 'poly', 'sigmoid', 'rbf']

# 创建一个图形，在图形中绘制四个子图
fig, axes = plt.subplots(2, 2, figsize=(10, 10))

# 遍历四种核函数
for i, kernel in enumerate(kernels):
    clf = SVC(kernel=kernel, C=1)  # 创建 SVC 分类器
    clf.fit(X_train, y_train)  # 用训练数据训练分类器
    y_pred = clf.predict(X_test)  # 用测试数据测试分类器
    accuracy = accuracy_score(y_test, y_pred)  # 计算分类器的准确率
    print("accuracy of " + kernel + ":" + str(accuracy))
    # 在对应的子图中绘制分类结果
    axes[i // 2, i % 2].scatter(X_test[:, 0], X_test[:, 1], c=y_pred)
    axes[i // 2, i % 2].set_title(f"Kernel: {kernel}, Accuracy: {accuracy:.2f}")
plt.show()

# 在对应的子图中绘制分类结果
axes[i // 2, i % 2].scatter(X_test[:, 0], X_test[:, 1], c=y_test)
axes[i // 2, i % 2].scatter(X_test[:, 0], X_test[:, 1], c=y_pred, marker='x')
axes[i // 2, i % 2].set_title(f"Kernel: {kernel}, Accuracy: {accuracy:.2f}")
