package com.cryallen.leetcode.easy.array;

import java.util.Arrays;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.array
 * @date ： 2024/5/13 23:37
 * Description ：Easy_977_Squares_Of_A_Sorted_Array
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_977_Squares_Of_A_Sorted_Array {

    /**
     * 977.有序数组的平方
     *
     * <p>
     * 地址：https://leetcode.cn/problems/squares-of-a-sorted-array/description/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     * </p>
     *
     * <p>
     * 解答：
     * </p>
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{-4,-1,0,3,10};
        int[] result1 = sortedSquaresAll(nums1);
        if(result1 != null){
            for (int j : result1) {
                System.out.println(j);
            }
        }

        int[] nums2 = new int[]{-7,-3,2,3,11};
        int[] result2 = sortedSquares(nums2);
        if(result2 != null){
            for (int j : result2) {
                System.out.println(j);
            }
        }
    }

    /**
     * 暴力解法
     * 时间复杂度高O(n^)
     * */
    public static int[] sortedSquaresAll(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 双指针写法
     * 时间复杂度高O(n)
     * */
    private static int[] sortedSquares(int[] nums) {
        if(nums == null ||  nums.length == 0){
            System.out.println("源数据数组为null或没有数据");
            return null;
        }
        int length = nums.length;
        int[] result = new int[length];

        for(int i = 0,j = length -1, k = length -1; i <= j; --k){
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if(left < right){
                result[k] = right;
                --j;
            }else{
                result[k] = left;
                ++i;
            }
        }
        return result;
    }

}
