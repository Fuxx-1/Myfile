import datetime
import os

import requests

# 参数列表
corpId = "wwdc80681c42c94333"  # 企业微信企业代码
corpSecret = "nAweSLLiaHBNEqBL5B_zxzYTAg_mOCklhH4p9sT4FKI"  # 企业微信应用secret

# corpId = os.environ['CorpId']  # 企业微信企业代码
# corpSecret = os.environ['CorpSecret']  # 企业微信应用secret


def getAccessToken():
    return requests.get(
        "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpId + "&corpsecret=" + corpSecret).json()[
        'access_token']


userlist = requests.get(
    url="https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=" + getAccessToken() + "&fetch_child=FETCH_CHILD&department_id=2").json()[
    "userlist"]  # 企业微信用户名列表


def getTime():
    return datetime.datetime.utcnow() + datetime.timedelta(hours=8.0)  # 获取时间


def getTimeStr():
    time_now = datetime.datetime.utcnow() + datetime.timedelta(hours=8.0)  # 获取时间
    return str(time_now.strftime("%Y-%m-%d %H:%M"))


def sendMessage():
    resp = requests.post(
        url="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + getAccessToken(), json={
            "toparty": "3",
            "msgtype": "textcard",
            "agentid": 1000003,
            "textcard": {
                "title": "打卡提醒\n点击跳转我在校园",
                "description": getTimeStr() + "\n已打卡请忽略",
                "url": "https://gw.wozaixiaoyuan.com/h5/mobile/basicinfo/index/",
            }
        }
    )


def main():
    sendMessage()


if __name__ == "__main__":
    main()
