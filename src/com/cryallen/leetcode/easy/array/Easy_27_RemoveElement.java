package com.cryallen.leetcode.easy.array;


/***
 * 27. 移除元素
 * @author Allen
 * @DATE 2020-11-16
 ***/
public class Easy_27_RemoveElement {
	/**
	 * 移除元素
	 *
	 * <p>
	 * 地址：https://leetcode-cn.com/problems/remove-element/
	 * </p>
	 *
	 * <p>
	 * 描述：
	 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
	 *
	 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	 *
	 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 *
	 * 示例 1:
	 给定 nums = [3,2,2,3], val = 3,

	 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

	 你不需要考虑数组中超出新长度后面的元素。

	 *
	 * 示例 2:
	 给定 nums = [0,1,2,2,3,0,4,2], val = 2,

	 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

	 注意这五个元素可为任意顺序。

	 你不需要考虑数组中超出新长度后面的元素。
	 *
	 * 说明:
	 为什么返回数值是整数，但输出的答案是数组呢?

	 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

	 *
	 * <p>
	 * 你可以想象内部操作如下:
	 *
	 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
	 * int len = removeElement(nums, val);
	 *
	 * // 在函数里修改输入数组对于调用者是可见的。
	 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
	 * for (int i = 0; i < len; i++) {
	 *     print(nums[i]);
	 * }
	 *
	 * </p>
	 */

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,1,2,2,11,15};
		int result1 = removeElement(nums1,2);
		System.out.println("result1: " + result1);

		int[] nums2 = new int[]{1,1,2,2,11,15};
		int result2 = removeElement2(nums2, 2);
		System.out.println("result2: " + result2);
	}

	/**
	 * 双角标，删除元素 时间复杂度O(n) 双指针法（快慢指针法）： **通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。**
	 * */
	public static int removeElement(int[] nums,int val) {
		int length = nums.length;
		if(length == 0){
			return 0;
		}
		int left = 0;
		for(int right = 0; right < length;right++){
			System.out.println("nums start left:" + left +",right:" + right);
			if(nums[right] != val) {
				nums[left] = nums[right];
				left++;
			}
			System.out.println("nums end left:" + left +",right:" + right);
		}
		return left;
	}

	/**
	 * 暴力删除法，时间复杂度O(n^)
	 * */
	public static int removeElement2(int[] nums,int val) {
		int length = nums.length;
		if(length == 0){
			return 0;
		}
		for(int i = 0; i < length; i++){
			if(nums[i] == val){ // 发现需要移除的元素，就将数组集体向前移动一位
				for (int j = i + 1; j < length; j++){
					nums[j - 1] = nums[j];
				}
				i--; // 因为下表i以后的数值都向前移动了一位，所以i也向前移动一位
				length--; // 此时数组的大小-1
			}
		}
		return length;
	}
}
