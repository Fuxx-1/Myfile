package main

import (
	"fmt"
	"os"
	"os/exec"
)

type snake struct {
	score  int
	ground [10][10]int
}

func main() {
	ch := make(chan string)
	go read(ch)
	updateSnake(ch)
}

func read(ch chan string) {
	v := <-ch
	fmt.Println(v)
}

func updateSnake(ch chan string) {
	v := <-ch
	fmt.Println(v)
}

func clear() {
	c := exec.Command("clear")
	c.Stdout = os.Stdout
	c.Run()
}

func (s snake) printGame() {
	ground := s.ground
	fmt.Printf("------------\n")
	for i := 0; i < 10; i++ {
		fmt.Printf("|%s|\n", ground[i])
	}
	fmt.Printf("------------\n")
}
