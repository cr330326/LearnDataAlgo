package com.cryallen.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * */
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,15};
        int target1 = 26;
        int[] result1 = twoSumAll(nums1,target1);
        if(result1!= null && result1.length ==2){
            System.out.println("value1: " + result1[0] + " ,result1: " + result1[1]);
        }else{
            System.out.println("result1 is error");
        }

        int[] nums2 = new int[]{3,2,3};
        int target2 = 6;
        int[] result2 = twoSumHash(nums2,target2);
        if(result2!= null && result2.length ==2){
            System.out.println("value1: " + result2[0] + " ,value2: " + result2[1]);
        }else{
            System.out.println("result2 is error");
        }
    }

    /**
     * 暴力遍历方法
     * 缺点：1，耗时，时间复杂度高O(n^)
     * */
    public static int[] twoSumAll(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        System.out.println("nums length:" + length + ",target:" + target);
        if(length == 0){
            return null;
        }

        for (int i = 0; i< length; i++){
            for(int j = i+1; j < length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Hash表方式 时间复杂度O(n)
     * */
    public static int[] twoSumHash(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        System.out.println("nums length:" + length + ",target:" + target);
        if(length == 0){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
