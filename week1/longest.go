package main

import (
	"fmt"
)

func longestSubstring(s string, k int) string {
	maxString := ""
	startIndex := 0
	maxLength := 0
	m := make(map[rune]int, 0)
	for i := 0; i < len(s); i++ {
		char := rune(s[i])
		if m[char] != 0 {
			m[char]++
		} else {
			m[char] = 1
		}

		if len(m) > k {
			if maxLength < (i - startIndex) {
				maxLength = (i - startIndex)
				maxString = s[startIndex:i]
			}
		}
		for len(m) > k {
			temp := rune(s[startIndex])
			tempValue := m[temp]
			if tempValue > 1 {
				m[temp]--
			} else {
				delete(m, temp)
			}
			startIndex++
		}
	}
	if maxLength < (len(m) - startIndex) {
		maxString = s[startIndex:len(m)]
	}

	return maxString
}

func main() {
	fmt.Println(longestSubstring("abcba", 2))
}
