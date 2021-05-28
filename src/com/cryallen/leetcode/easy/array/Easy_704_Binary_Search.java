package com.cryallen.leetcode.easy.array;

/***
 * 704. 二分查找
 * @author Allen
 * @DATE 2021-5-28
 ***/
public class Easy_704_Binary_Search {

    /**
     * 704. 二分查找
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/binary-search/
     * </p>
     *
     * <p>
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * 示例 1:
     输入: nums = [-1,0,3,5,9,12], target = 9
     输出: 4
     解释: 9 出现在 nums 中并且下标为 4

     *
     * 示例 2:
     输入: nums = [-1,0,3,5,9,12], target = 2
     输出: -1
     解释: 2 不存在 nums 中因此返回 -1

     提示：

     1,你可以假设 nums 中的所有元素是不重复的。
     2,n 将在 [1, 10000]之间。
     3,nums 的每个元素都将在 [-9999, 9999]之间。

     思路：
     这道题目的前提是数组为有序数组，同时题目还强调**数组中无重复元素，因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的，这些都是使用二分法的前提条件，当大家看到题目描述满足如上条件的时候，可要想一想是不是可以用二分法了。

     二分查找涉及的很多的边界条件，逻辑比较简单，但就是写不好。例如到底是 `while(left < right)` 还是 `while(left <= right)`，到底是`right = middle`呢，还是要`right = middle - 1`呢？

     大家写二分法经常写乱，主要是因为**对区间的定义没有想清楚，区间的定义就是不变量**。要在二分查找的过程中，保持不变量，就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作，这就是**循环不变量**规则。

     写二分法，区间的定义一般为两种，左闭右闭即[left, right]，或者左闭右开即[left, right)。
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,3,5,9,12};
        int result1 = search1(nums1,9);
        System.out.println("result1: " + result1);

        int result2 = search2(nums1,9);
        System.out.println("result2: " + result2);
    }

    /**
     * 方式1:二分查找 左闭右闭
     * */
    public static int search1(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length -1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right){ // 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + ((right - left) >> 2); // 防止溢出 等同于(left + right)/2
            if(nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 方式1:二分查找 左闭右闭
     * */
    public static int search2(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length -1; // 定义target在左闭右开的区间里，即：[left, right)
        while (left < right){  // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int middle = left + ((right - left) >> 2);
            if(nums[middle] == target){
                return middle;
            } else if (nums[middle] > target){
                right = middle; // target 在左区间，在[left, middle)中
            }else{
                left = middle + 1; // target 在右区间，在[middle + 1, right)中
            }
        }
        return -1;
    }

    /**
     * 方式1:二分查找 左闭右闭 [left,right]
     * */
    public static int search3(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }

        if(target < nums[0] || target > nums[length - 1]){
            return -1;
        }

        int left = 0;
        int right = length - 1;
        int middle = 0;
        while (left <= right){ // 定义target在左闭右闭的区间里，[left, right]
            middle = left + ((right - left) >> 2);
            if(nums[middle] == target){
                return middle;
            }else if (nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }
}
