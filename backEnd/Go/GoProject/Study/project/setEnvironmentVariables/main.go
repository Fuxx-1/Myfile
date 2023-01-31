package main

import (
	"fmt"
	"os"
	"time"
)

// Deprecated
func main() {
	choice := 1
	for {
		// 循环
		// 打印菜单
		fmt.Println(
			"[0]退出\t", "[1]Go环境设置\t", "[2]Java环境设置\t", "[3]Maven环境设置\t",
		)
		// 获取输入并处理错误
		scanf, err := fmt.Scan(&choice)
		if err != nil {
			panic(err)
		}
		if scanf <= 0 {
			panic("Scan Error")
		}
		// 处理具体逻辑
		switch choice {
		case 1:
			fmt.Println(os.Getenv("Test"))
			setGoEnvironment()
		case 2:
			setJavaEnvironment()
		case 3:
			setMavenEnvironment()
		default:
			fmt.Println("退出ing")
			return
		}
	}
}
func setGoEnvironment() {
	os.Setenv("Test", "test")
	fmt.Println(os.Getenv("Test"))
	time.Sleep(time.Second * 5)
}
func setJavaEnvironment() {

}
func setMavenEnvironment() {

}
