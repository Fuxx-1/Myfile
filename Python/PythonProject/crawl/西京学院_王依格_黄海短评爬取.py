#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import pandas as pd
import requests
from bs4 import BeautifulSoup
import os

# 自定义文件保存路径
os.chdir('./')
print("本次爬取输出位置: " + os.getcwd())

url = 'https://movie.douban.com/subject/3743114/comments?start=1&limit=100&status=P'
# url = 'https://movie.douban.com/subject/3743114/comments?status=P'
headers = {
    'User-Agent': "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54"
}

html = requests.get(url, headers=headers)
soup = BeautifulSoup(html.text, 'html.parser')

comments = soup.findAll('div', {'class': 'comment-item'})


# 创还能存取的列表
name_list = []
rating_list = []
time_list = []
text_list = []
count_list = []

fp = open('./黄海短评.txt', 'w', encoding='utf8')

for comment in comments:

    # 取名字
    name = comment.find('a')['title']
    name_list.append(name)  # 添加进列表中

    # 取评论内容
    text = comment.find('span', class_="short").text
    text_list.append(text)

    # 点赞数量(class 属性有多个值时 选择性取用)
    count = comment.find('span', class_="votes").text
    count_list.append(count)

    # 取时间
    time = comment.find('span', class_="comment-time")['title'].split()[0]
    time_list.append(time)

    # 取评级
    if comment.find('span', class_='rating') is None:
        rating = "None"
    else:
        rating = comment.find('span', class_='rating')['title']
    rating_list.append(rating)

    # 连接文本 rating
    data = name + ';' + rating + ';' + time + '\n' + text + '\n' + count + '\n' + '\n'

    # 写入文本
    fp.write(data)

fp.close()
print("爬取完成")

# 写入excel表格
message = pd.DataFrame(
    {'用户': name_list, '推荐力度': rating_list, '时间': time_list, '短评': text_list, '点赞数': count_list})
message.to_excel('./黄海短评.xlsx')
