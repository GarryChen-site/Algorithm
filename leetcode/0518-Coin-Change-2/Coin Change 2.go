package leetcode

func change(amount int, coins []int) int {
	dp := make([]int, amount+1)
	// 凑成总金额0的货币组合数为1
	dp[0] = 1

	for _, coin := range coins {
		for i := coin; i <= amount; i++ {
			dp[i] += dp[i-coin]
		}
	}
	return dp[amount]
}
