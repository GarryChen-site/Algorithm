package leetcode.greedy.wiggle_subsequence;

public class Solution {

	/**
	 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. 
	 * The first difference (if one exists) may be either positive or negative. 
	 * A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
	 * 
	 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
	 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. 
	 * The first is not because its first two differences are positive, and the second is not because its last difference is zero.
	 * 
	 * A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
	 * 
	 * Given an integer array nums, return the length of the longest wiggle subsequence of nums.
	 * 
	 * Input: nums = [1,7,4,9,2,5]
	 * Output: 6
	 * Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
	 * 
	 * Input: nums = [1,17,5,10,13,15,10,5,16,8]
	 * Output: 7
	 * Explanation: There are several subsequences that achieve this length.
	 * One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
	 * 
	 * Input: nums = [1,2,3,4,5,6,7,8,9]
	 * Output: 2
	 * 
	 * @param nums
	 * @return
	 */
	public int wiggleMaxLength(int[] nums)
	{
		if(2 > nums.length )
		{
			return nums.length;
		}

		// return 1 + Math.max(calculate(nums, 0,true), calculate(nums,0, false));

		int prevdiff = nums[1] - nums[0];
		int count = prevdiff != 0 ? 2 : 1;
		for(int i = 2; i < nums.length; i++)
		{
			int diff = nums[i] - nums[i-1];
			if((diff > 0 && prevdiff <=0) || (diff < 0 && prevdiff >= 0))
			{
				count++;
				prevdiff = diff;
			}
		}

		return count;
		
	}

	/**
	 * 
	 * @param nums
	 * @param index from which we need to find the length of the longest wiggle subsequence
	 * @param isUp tell whether we need to find an increasing wiggle or decreasing wiggle respectively
	 * @return
	 */
	private int calculate(int[] nums, int index, boolean isUp) 
	{
		int maxCount = 0;

		for(int i= index + 1; i < nums.length; i++)
		{
			if((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
			{
				maxCount = Math.max(maxCount, 1 + calculate(nums, i, !isUp));
			}
		}
		return maxCount;
	}
	
}
