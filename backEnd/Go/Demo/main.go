package main

import (
	"fmt"
	"time"
)

func main() {
	var a int = 0
	fmt.Println("start")
	fmt.Scanf("%d", &a)
	fmt.Println(a)

	sleep(1 * time.Second)
	sleep(500 * time.Millisecond)
	sleep(500 * time.Microsecond)

	start := time.Now()
	sleep(1 * time.Second)
	elapsed := time.Since(start)

	fmt.Println(elapsed)
}

func sleep(d time.Duration) bool {
	time.Sleep(d)
	println(d)
	return true;
}