package leetcode

func findPeakElement(nums []int) int {

	low , high := 0, len(nums)-1

	for low < high {
		mid := low + (high-low)/2
		// 如果 mid 较大，则左侧存在峰值，high = m，如果 mid + 1 较大，则右侧存在峰值，low = mid + 1
		if nums[mid] > nums[mid+1] {
			high = mid
		} else {
			low = mid + 1
		}
	}
	return low
}