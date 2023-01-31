#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os

if __name__ == '__main__':
    fileNames = os.listdir("./")
    for fileName in fileNames:
        if fileName != "文件批量重命名.py":
            os.rename(fileName, "西京学院_王依格_" + fileName)
