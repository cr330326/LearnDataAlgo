package com.cryallen.leetcode.easy.array;


/***
 * 35. 搜索插入位置
 * @author Allen
 * @DATE 2021-5-11
 ***/
public class Easy_35_Search_Insert_Position {
	/**
	 * 搜索插入位置
	 *
	 * <p>
	 * 地址：https://leetcode-cn.com/problems/search-insert-position/
	 * </p>
	 *
	 * <p>
	 * 描述：
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 *
	 * 示例 1:
	 输入: [1,3,5,6], 5
	 输出: 2

	 *
	 * 示例 2:
	 输入: [1,3,5,6], 2
	 输出: 1

	 *
	 * 示例 3:
	 输入: [1,3,5,6], 7
	 输出: 4

	 *
	 * 示例 4:
	 输入: [1,3,5,6], 0
	 输出: 0

	 */

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3,5,6};
		int result1 = searchInsert(nums1,5);
		System.out.println("result1: " + result1);

		int result2 = searchInsert(nums1,7);
		System.out.println("result2: " + result2);

		int result3 = searchInsert(nums1,2);
		System.out.println("result3: " + result3);

		int result4 = searchInsert(nums1,0);
		System.out.println("result4: " + result4);
	}

	/**
	 * 单循环查找
	 * */
	public static int searchInsert(int[] nums,int target) {
		int length = nums.length;
		if(length == 0){
			return 0;
		}
		int result = 0;
		for(int i = 0; i < length; i++){
			if(nums[i] == target){
				result = i;
				break;
			}

			if(target < nums[i]){
				result = i;
				break;
			}else{
				result = i + 1;
			}

		}
		return result;
	}
}
