package main

import (
	"fmt"
)

func stairCase(num int, X map[int]bool) int {
	memo := make([]int, num+1)
	memo[0] = 1

	for i := 0; i < num+1; i++ {
		if X[i] == true {
			memo[i]++
		}
		sum := 0
		for e := range X {
			if (i - e) > 0 {
				sum += memo[i-e]
			}
		}
		memo[i] += sum
	}

	return memo[len(memo)-1]
}

func main() {

	var set = make(map[int]bool, 0)
	set[1] = true
	set[2] = true
	fmt.Println(stairCase(4, set))
}
