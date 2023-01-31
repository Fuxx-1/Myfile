package main

import "fmt"

func main() {
	for i := 0; i < 10; i++ {
		fmt.Println(i)
	}
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			fmt.Printf("* ")
		}
		fmt.Println()
	}
	for i := 1; i < 10; i++ {
		for j := 1; j < 10; j++ {
			if i >= j {
				fmt.Printf("%d*%d=%02d ", j, i, i*j)
			}
		}
		fmt.Println()
	}
}
