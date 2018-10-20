package main

import (
	"fmt"
	"math/rand"
	"sync"
)

var wg sync.WaitGroup

func solution(stream <-chan int) <-chan int {
	res := make(chan int, 1)

	go func() {
		var result int
		var lastProb float64
		for element := range stream {
			actualProb := rand.Float64()
			if actualProb > lastProb {
				result = element
				actualProb = lastProb
			}
		}

		res <- result
	}()

	return res
}

func main() {
	stream := make(chan int, 3)
	stream <- 1
	stream <- 2
	stream <- 5

	v := solution(stream)
	fmt.Println(v)

}
