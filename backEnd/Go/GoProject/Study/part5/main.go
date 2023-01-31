package main

import (
	"fmt"
	"strconv"
	"time"
)

func main() {
	source := 100
	for i := 0; i < 10; i++ {
		go sale(&source, strconv.Itoa(i))
	}
	time.Sleep(time.Second * 5)
	fmt.Println(source)
}

func sale(source *int, info string) {
	time.Sleep(time.Second * 2)
	for i := 0; i < 11; i++ {
		if *source > 0 {
			*source--
		}
		fmt.Println(info + "购票成功, 剩余" + strconv.Itoa(*source))
	}
}
