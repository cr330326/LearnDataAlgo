package com.cryallen.leetcode.easy.array;
import java.util.*;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.array
 * @date ： 2024/5/15 14:34
 * Description ：Easy_1365_How_Many_Numbers
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_1365_How_Many_Numbers {

    /**
     * 1365. 有多少小于当前数字的数字
     *
     * <p>
     * 地址：https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/description/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     *
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     *
     * 以数组形式返回答案。
     *
     示例 1：

     输入：nums = [8,1,2,2,3]
     输出：[4,0,1,1,3]
     解释：
     对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     对于 nums[1]=1 不存在比它小的数字。
     对于 nums[2]=2 存在一个比它小的数字：（1）。
     对于 nums[3]=2 存在一个比它小的数字：（1）。
     对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     示例 2：

     输入：nums = [6,5,4,8]
     输出：[2,1,0,3]
     示例 3：

     输入：nums = [7,7,7,7]
     输出：[0,0,0,0]


     提示：

     2 <= nums.length <= 500
     0 <= nums[i] <= 100
     * </p>
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{8,1,2,2,3};
        int[] result1 = smallerNumbersThanCurrent(nums1);
        System.out.println("result1: " + Arrays.toString(result1));
    }

    /**
     * 方法一：排序 + 二分查找
     * 数组numbs 复制一份，记为arr，然后对arr进行升序排序
     * 然后对nums中的每个元素x，可以通过二分查找的方法找到第一个大于等于x的元素下标j,那么j就是比x小的元素个数，我们将j存入答案组中即可
     * 时间复杂度O(n×logn)
     * */
    private static int[] smallerNumbersThanCurrent(int[] nums) {
        //先拷贝一份数组
        int[] arr = nums.clone();
        //然后进行升序排序
        Arrays.sort(arr);
        System.out.println("arr升序值: " + Arrays.toString(arr));
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = binarySearch(arr, nums[i]);
        }
        return nums;
    }

    /**
     * 二分查找 左闭右开方式
     * */
    private static int binarySearch(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) { // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
