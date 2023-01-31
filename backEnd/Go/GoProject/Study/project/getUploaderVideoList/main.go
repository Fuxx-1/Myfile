package main

import (
	"bytes"
	"fmt"
	"github.com/tidwall/gjson"
	"golang.org/x/text/encoding/simplifiedchinese"
	"golang.org/x/text/transform"
	"io/ioutil"
	"net/http"
	"os"
	"strconv"
	"time"
)

func main() {
	// 14890801
	var upId string
	fmt.Println("请输入up主id")
	_, err := fmt.Scanln(&upId)
	if err != nil {
		panic(err)
	}
	getVideoList(upId)
}

func initFile(upId string) {
	file, _ := os.OpenFile("./"+upId+".csv", os.O_CREATE|os.O_RDWR|os.O_TRUNC, 0777)
	writeString, err := file.WriteString(Utf8ToGbk("标题,播放量,链接,时长,创建时间,作者\n"))
	defer file.Close()
	if err != nil {
		panic(err)
	}
	if writeString <= 0 {
		panic("writeFile Error")
	}
}

func writeFile(results gjson.Result, upId string) error {
	file, _ := os.OpenFile("./"+upId+".csv", os.O_CREATE|os.O_RDWR|os.O_APPEND, 0777)
	for _, result := range results.Get("data.list.vlist").Array() {
		/* 获取时间字符串 */
		timestamp := result.Get("created").Int()
		tm := time.Unix(timestamp, 0)
		created := tm.Format("2006-01-02 15:04:05")
		var vList VList = VList{
			title:   result.Get("title").String(),
			play:    int(result.Get("play").Int()),
			link:    "https://www.bilibili.com/video/" + result.Get("bvid").String(),
			length:  result.Get("length").String(),
			created: created,
			author:  result.Get("author").String(),
		}
		writeString, err := file.WriteString(Utf8ToGbk(vList.getCsv())) // 写入文件
		if err != nil {
			panic(err)
		}
		if writeString <= 0 {
			panic("writeFile Error")
		}
	}
	return nil
}

func getVideoList(upId string) error {
	var count int
	initFile(upId)
	for i := 1; i < count/30+2 || i == 1; i++ {
		response := getVideoInf(i, 30, upId)
		result := respToResult(response)
		err := writeFile(result, upId)
		if err != nil {
			panic(err)
		}
		if i == 1 {
			count = int(result.Get("data.page.count").Int()) // 首次请求更新count值
			fmt.Println("Total: ", count)
		}
		fmt.Printf("%sWrite -> %05d", "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b", i*30)
	}
	fmt.Printf("%s%s", "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b", "the csv generate over")
	return nil
}

func getVideoInf(pageNo int, pageSize int, upId string) *http.Response {
	url := "https://api.bilibili.com/x/space/wbi/arc/search?" +
		"mid=" + upId +
		"&pn=" + strconv.Itoa(pageNo) +
		"&ps=" + strconv.Itoa(pageSize) +
		"&order=pubdate"
	client := &http.Client{}
	reqest, err := http.NewRequest("GET", url, nil)
	reqest.Header.Add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54")
	if err != nil {
		panic(err)
	}
	response, err := client.Do(reqest)
	if err != nil {
		panic(err)
	}
	if response.StatusCode != 200 {
		panic("Http request failed")
	}
	return response
}

func respToResult(response *http.Response) gjson.Result {
	defer response.Body.Close()
	respBuf := new(bytes.Buffer)
	respBuf.ReadFrom(response.Body)
	respStr := respBuf.String()
	return gjson.Parse(respStr)
}

func Utf8ToGbk(s string) string {
	oldByte := []byte(s)
	reader := transform.NewReader(bytes.NewReader(oldByte), simplifiedchinese.GBK.NewEncoder())
	d, _ := ioutil.ReadAll(reader)
	return string(d)
}
