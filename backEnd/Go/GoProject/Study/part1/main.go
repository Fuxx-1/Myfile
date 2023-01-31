package main

import (
	"fmt"
	"math/rand"
	"time"
	"unsafe"
)

// global variable
var globalVariable string = "globalVariable"

func main() {
	fmt.Println("[Class1]")
	fmt.Println("Hello World")

	fmt.Println("\n[Class2~3]")
	/*
		多行注释
	*/
	// 单行注释
	var a string = "a1"
	fmt.Println("a(before change): " + a)
	a = "a2"
	fmt.Println("a: " + a)

	fmt.Println("\n[Class4]")
	var (
		name string
		age  int
		addr string
	)
	fmt.Println("[name:", name, ", age:", age, ", addr:", addr, "]")

	fmt.Println("\n[Class5~6]")
	name = "Name"
	age = 18
	addr = "Test"
	fmt.Println("[name:", name, ", age:", age, ", addr:", addr, "]")
	test := "test"
	fmt.Printf("[%s]->%T->%p\n", test, test, &test)

	fmt.Println("\n[Class7]")
	b, c := 1, 2
	fmt.Println("[b:", b, ", c:", c, "](before change)")
	b, c = c, b
	fmt.Println("[b:", b, ", c:", c, "]")

	fmt.Println("\n[Class8]")
	d, _ := funcTest() // 返回给"_"的东西均会被丢弃
	fmt.Println(d, "(before change)")
	_, d = funcTest() // 返回给"_"的东西均会被丢弃
	fmt.Println(d)

	fmt.Println("\n[Class9]") // see Line 6
	fmt.Println("globalVariable: ", globalVariable)
	var globalVariable string = "localVariable"
	fmt.Println("globalVariable: ", globalVariable) // 优先局部变量

	fmt.Println("\n[Class9]")
	const url1 = "url1"
	const url2 string = "url2"
	fmt.Println("[url:", url1, ", url2:", url2)

	fmt.Println("\n[Class10]")
	const ( // iota 为常量计数器
		ca = iota
		cb
		cc = "test"
		cd
		ce = 1
		cf = iota
	)
	const cg = iota
	fmt.Println(ca, cb, cc, cd, ce, cf)
	fmt.Println(cg)

	fmt.Println("\n[Class11~15]")
	var (
		isBool bool    = true                    // default false
		num    int     = 1                       // default 0 byte, rune, uint, int, uintptr
		float  float64 = 2.5092                  //default 0
		str    string  = "\"sasdf\t" + "gater\"" // default ""
	)
	fmt.Printf("%T->%t->%d\n", isBool, isBool, unsafe.Sizeof(isBool))
	fmt.Printf("%T->%d->%d\n", num, num, unsafe.Sizeof(num))
	fmt.Printf("%T->%.5f->%d\n", float, float, unsafe.Sizeof(float))
	fmt.Printf("%T->%s->%d\n", str, str, unsafe.Sizeof(str))
	fmt.Println(num + int(float))

	fmt.Println("\n[Class16~19]")
	rand.Seed(int64(time.Now().Nanosecond()))
	num1 := rand.Intn(2)
	if num1 == 0 || !isBool {
		fmt.Println("0")
	} else {
		fmt.Println("1")
	}

	/*
				  a       b      res
			&    0011    0101    0001
			|    0011    0101    0111
			^    0011    0101    0110
			&^   0011    0101    0010
		    >>  左移  <<  右移
	*/

	fmt.Println("\n[Class20]")
	var (
		da int
		db float64
	)
	fmt.Scan(&da, &db)
	fmt.Println(da, db)
}

func funcTest() (int, int) {
	return 100, 200
}
