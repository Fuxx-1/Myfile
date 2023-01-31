package main

import "fmt"

func main() {
	test()
	// fmt.Println(add(1, 2, 3, 4, 5))
}

func add(values ...int) int {
	var result int
	for value := range values {
		result += value
	}
	return result
}

func test() {
	user1 := make(map[string]string)
	user1["name"] = "NAME1"
	user1["age"] = "AGE1"
	user1["sex"] = "SEX1"
	user1["addr"] = "ADDR1"

	user2 := make(map[string]string)
	user2["name"] = "NAME2"
	user2["age"] = "AGE2"
	user2["sex"] = "SEX2"
	user2["addr"] = "ADDR2"

	userMap := make([]map[string]string, 0, 8)
	userMap = append(userMap, user1)
	userMap = append(userMap, user2)
	fmt.Println(userMap)
}
