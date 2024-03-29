package leetcode


func candy(ratings []int) int {

	// n := len(ratings)

	// left := make([]int, n)

	// ans := 0

	// for i,r := range ratings {
	// 	if i > 0 && r > ratings[i-1] {
	// 		left[i] = left[i-1] + 1
	// 	} else {
	// 		left[i] = 1
	// 	}
	// }

	// right := 0;

	// for i := n-1; i>=0; i-- {
	// 	if i < n-1 && ratings[i] > ratings[i+1] {
	// 		right++
	// 	} else {
	// 		right = 1
	// 	}
	// 	ans += max(left[i], right)
	// }
	// return ans

	n := len(ratings)
	// inc ,dec 表示长度
	ans, inc, dec, pre := 1,1,0,1
	for i:=1; i<n; i++ {
		if ratings[i] >= ratings[i-1] {
			dec = 0
			if ratings[i] == ratings[i-1]{
				pre = 1
			} else {
				pre++
			}
			ans += pre
			inc = pre
		} else {
			dec++
			if dec == inc {
				dec ++
			}
			ans += dec
			pre = 1
		}
	}

	return ans

}

func max(a,b int) int {
	if a > b {
		return a
	}

	return b
}