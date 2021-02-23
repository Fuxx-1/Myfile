import pandas as pd
import numpy as np

tip1 = input('请输入文件名：')
tip2 = input('请输入起始列数： ')
tip3 = input('请输入结束列数： ')


def read_excel(tip1, tip2, tip3):
    data1 = pd.read_excel(str(tip1))
    numpy_data = np.array(data1.iloc[:, int(tip2)+1:int(tip3)+1]).astype(float)
    data = numpy_data.tolist()

    with open('test.txt', 'w') as file:
        for i in range(len(data)):
            s = str(data[i]).replace('[', '').replace(']', '')
            s = s.replace("'", '').replace(',', '') + '\n'
            file.write(s)
            return '结束'


if __name__ == "__main__":
    read_excel(tip1, tip2, tip3)
