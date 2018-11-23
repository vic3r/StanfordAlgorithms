package main

import "fmt"

// Implementation Done in O(nlog(n))+ O(n) = O(nlog(n))

// Handler is a struct which stores a description
type Handler struct {
	description string
}

// Merge unifies two structs
func Merge(left, right []int) []int {
	size, i, j := len(left)+len(right), 0, 0
	slice := make([]int, size, size)

	for k := 0; k < size; k++ {
		if i > len(left)-1 && j <= len(right)-1 {
			slice[k] = right[j]
			j++
		} else if j > len(right)-1 && i <= len(left)-1 {
			slice[k] = left[i]
			i++
		} else if left[i] < right[j] {
			slice[k] = left[i]
			i++
		} else {
			slice[k] = right[j]
			j++
		}
	}

	return slice
}

// MergeSort does the merge sort algorithm
func MergeSort(slice []int) []int {
	if len(slice) < 2 {
		return slice
	}

	mid := len(slice) / 2
	return Merge(MergeSort(slice[mid:]), MergeSort(slice[:mid]))
}

func (h *Handler) findFirstNonRepeated(arr []int) int {
	arr = MergeSort(arr)
	max := 3

	for i := 1; i <= len(arr); i++ {
		if arr[i-1] == arr[i] {
			max--
		} else {
			if max > 0 {
				return arr[i-1]
			}
			max = 3
		}
	}
	return -1
}

func main() {
	h := &Handler{}
	arrs := []int{6, 1, 3, 3, 3, 6, 6}
	result := h.findFirstNonRepeated(arrs)
	fmt.Println(result)
}
