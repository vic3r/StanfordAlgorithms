package main

import "fmt"

func calculateMaxProfit(arr []int) int {
	max := 0
	index := 0
	for i := 1; i < len(arr); i++ {
		if arr[i] < arr[index] {
			index = i
			continue
		}
		diff := arr[i] - arr[index]
		if diff > max {
			max = diff
		}
	}
	return max
}

func main() {
	arr := []int{9, 11, 8, 5, 7, 10}
	result := calculateMaxProfit(arr)
	fmt.Println(result)
}
