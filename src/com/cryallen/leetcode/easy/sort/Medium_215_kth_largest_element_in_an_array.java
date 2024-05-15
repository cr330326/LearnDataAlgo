package com.cryallen.leetcode.easy.sort;

import java.util.Arrays;

/***
 * 215. 数组中的第K个最大元素
 * @author Allen
 * @DATE 2020-06-03
 ***/
public class Medium_215_kth_largest_element_in_an_array {

    /**
     * 215. 数组中的第K个最大元素
     * <p>
     * 地址：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     * </p>
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 示例1：
     输入: [3,2,1,5,6,4] 和 k = 2
     输出: 5

     * 示例2：
     输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     输出: 4
     *
     *你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     *
     * */
    public static void main(String[] args) {
        int[] nums1 = new int[]{3 ,2 ,1 ,5 ,6 ,4};
        int result1 = findKthLargest1(nums1,2);
        System.out.println("result1: " + result1);

        int result2 = findKthLargest2(nums1,2);
        System.out.println("result2: " + result2);
    }

    /**
     * 暴力遍历法
     * 题目要求我们找到“数组排序后的第 kk 个最大的元素，而不是第 kk 个不同的元素” ，
     *
     * 语义是从右边往左边数第 k 个元素（从 11 开始），那么从左向右数是第几个呢，我们列出几个找找规律就好了。
     *
     * 一共 66 个元素，找第 22 大，索引是 44；
     * 一共 66 个元素，找第 44 大，索引是 22。
     * 因此，升序排序以后，目标元素的索引是 len - k。这是最简单的思路。
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    /**
     * 以下的描述基于 “快速排序” 算法知识的学习，如果忘记的朋友们可以翻一翻自己的《数据结构与算法》教材，复习一下，partition 过程、分治思想和 “快速排序” 算法的优化。
     *
     * 分析：我们在学习 “快速排序” 的时候，接触的第 1 个操作就是 partition（切分），简单介绍如下：
     *
     * partition（切分）操作，使得：
     *
     * 对于某个索引 j，nums[j] 已经排定，即 nums[j] 经过 partition（切分）操作以后会放置在它 “最终应该放置的地方”；
     * nums[left] 到 nums[j - 1] 中的所有元素都不大于 nums[j]；
     * nums[j + 1] 到 nums[right] 中的所有元素都不小于 nums[j]。
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
