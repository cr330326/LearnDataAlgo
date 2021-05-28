package com.cryallen.leetcode.easy.array;


/***
 * 209. 长度最小的子数组
 * @author Allen
 * @DATE 2021-5-26
 ***/
public class Medium_209_Minimum_Size_SubArray_Sum {
	/**
	 * 209. 长度最小的子数组
	 *
	 * <p>
	 * 地址：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
	 * </p>
	 *
	 * <p>
	 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
	 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
	 *
	 * 示例 1:
	 输入：target = 7, nums = [2,3,1,2,4,3]
	 输出：2
	 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

	 *
	 * 示例 2:
	 输入：target = 4, nums = [1,4,4]
	 输出：1

	 *
	 * 示例 3:
	 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
	 输出：0

	 提示：

	 1 <= target <= 109
	 1 <= nums.length <= 105
	 1 <= nums[i] <= 105
	 */

	public static void main(String[] args) {
		int[] nums1 = new int[]{2,3,1,2,4,3};
		int result1 = minSubArrayLen(7,nums1);
		System.out.println("result1: " + result1);

		int[] nums2 = new int[]{2,3,1,2,4,3};
		int result2 = minSubArrayLenSlide(7,nums2);
		System.out.println("result2: " + result2);
	}

	/**
	 * 方式1:暴力解法
	 * */
	public static int minSubArrayLen(int target, int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++){
			int sum = 0;
			for (int j = i; j < nums.length; j++){
				sum += nums[j];
				if(sum >= target){
					ans = Math.min(ans,j - i + 1);
					break;
				}
			}
		}

		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	/**
	 * 方式2: 滑动窗口方法
	 * */
	public static int minSubArrayLenSlide(int target, int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int start = 0, end = 0;
		int sum = 0;
		while (end < nums.length) {
			sum += nums[end];
			while (sum >= target) {
				ans = Math.min(ans, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}
