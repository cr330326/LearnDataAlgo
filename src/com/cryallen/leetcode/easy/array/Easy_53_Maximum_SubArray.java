package com.cryallen.leetcode.easy.array;


/***
 * 53, 最大子序和
 * @author Allen
 * @DATE 2021-5-10
 ***/
public class Easy_53_Maximum_SubArray {
	/**
	 * 最大子序和
	 *
	 * <p>
	 * 地址：https://leetcode-cn.com/problems/maximum-subarray/
	 * </p>
	 *
	 * <p>
	 * 描述：
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 *
	 * 示例 1:
	 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
	 输出：6
	 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

	 *
	 * 示例 2:
	 输入：nums = [1]
	 输出：1

	 *
	 * 示例 3:
	 输入：nums = [0]
	 输出：0

	 *
	 * 示例 4:
	 输入：nums = [-1]
	 输出：-1

	 *
	 * 示例 5:
	 输入：nums = [-100000]
	 输出：-100000

	 提示：

	 1 <= nums.length <= 3 * 104
	 -105 <= nums[i] <= 105
	 */

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,1,2,2,11,15};
		int result1 = maxSubArray(nums1);
		System.out.println("result1: " + result1);
	}

	/**
	 * 贪心算法
	 * */
	public static int maxSubArray(int[] nums) {
		if(nums.length == 1){
			return nums[0];
		}
		int maxSubArray = nums[0];
		int sum = nums[0];
		for(int i = 1; i < nums.length; i++){
			//sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
			sum = Math.max(sum,0);
			sum += nums[i];
			//maxSubArray始终取最大值
			maxSubArray = Math.max(sum,maxSubArray);
		}
		return maxSubArray;
	}
}
