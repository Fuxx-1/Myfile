package main

import (
	"fmt"
)

func main() {

	var (
		num int
	)

	fmt.Printf("输入成绩([0, 100]): ")
	fmt.Scan(&num)

	fmt.Printf("您输入的是: %d, ", num)

	// if 语句 允许嵌套
	if num < 0 || num > 100 {
		if num < 0 {
			fmt.Printf("成绩下不合法, ")
		} else {
			fmt.Printf("成绩上不合法, ")
		}
	} else {
		if num < 60 {
			fmt.Printf("成绩不及格, ")
		} else if num < 85 {
			fmt.Printf("成绩及格, ")
		} else if num <= 100 {
			fmt.Printf("成绩优秀, ")
		}
	}

	switch num {
	case 66:
		fmt.Printf("且成绩6")
	case 88:
		fmt.Printf("且成绩8")
	default:
		fmt.Printf("但是成绩平平无奇")
		// fallthrough 允许穿透
	}
}
