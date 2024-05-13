package com.cryallen.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.array
 * @date ： 2024/5/13 16:41
 * Description ：Easy_1_TwoSum_New
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_1_TwoSum_New {

    /**
     * 两数之和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/two-sum/description/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数数组 num 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
     * </p>
     *
     * <p>
     * 解答：暴力遍历，寻找目标元素
     * </p>
     */

    public static void main(String[] args){
       /* int[] test1 = new int[]{2,7,11,15};
        int target1 = -9;
        testCase(test1,target1);

        int[] test2 = new int[]{2,7,11,15};
        int target2 = 9;
        testCase(test2,target2);

        int[] test3 = new int[]{3,2,3};
        int target3 = 5;
        testCase(test3,target3);

        int[] test4 = new int[]{2,7,11,15};
        int target4 = 26;
        testCase(test4,target4);*/

        String str = "abc123!@#";
        String reg = "\\w*";
        for (char c : str.toCharArray()) {
            if (!Character.isAlphabetic(c) &&!Character.isWhitespace(c) &&!Character.isDigit(c)) {
                System.out.println(c);
            }
        }

        List<String> matchStrs = new ArrayList<>();
        Pattern pattern=  Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            matchStrs.add(matcher.group());
        }

        for (String s: matchStrs){
            System.out.println(s);
        }
    }

    /**
     * 暴力遍历，寻找目标元素 测试方法
     * @param testNum 测试源数组
     * @param testTarget 测试目标值
     */
    private static void testCase(int[] testNum,int testTarget){
        //int[] result = twoSumAllNew(testNum,testTarget);
        int[] result = twoSumAllByHash(testNum,testTarget);
        if(result != null){
            for (int i = 0; i < result.length; i++){
                System.out.println("目标元素的下标：" + result[i]);
            }
        }else{
            System.out.println("目标数组找不到值");
        }
    }


    /**
     * 暴力遍历，寻找目标元素
     * @param nums 源数组
     * @param target 目标值
     * @return result[]
     */
    private static int[] twoSumAllNew(int[] nums,int target){
        int[] result = new int[2];
        int length = nums.length;
        System.out.println("twoSumAllNew 输入的数组长度："+ length + ",目标值："+ target);

        if(length == 0 || target < 0){
            System.out.println("twoSumAllNew 输入的数组长度为0或者目标值为空");
            return null;
        }

        //for循环，两层循环，暴力查找
        for(int i = 0 ; i < length; i++){
            for (int j = i+1; j < length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;  // return 代表跳出整个函数，不管是循环里面还是循环外面都不执行
                }
            }
        }

        return result;
    }

    /**
     * Hash存储，寻找目标元素
     * @param nums 源数组
     * @param target 目标值
     * @return result[]
     */
    private static int[] twoSumAllByHash(int[] nums,int target){
        int[] result = new int[2];
        int length = nums.length;
        System.out.println("twoSumAllNew 输入的数组长度："+ length + ",目标值："+ target);

        if(length == 0 || target < 0){
            System.out.println("twoSumAllNew 输入的数组长度为0或者目标值为空");
            return null;
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            int temp = target - nums[i];
            if(hashMap.containsKey(temp)){
                result[1] = i;
                result[0] = hashMap.get(temp);
                return result;
            }
            hashMap.put(nums[i],i);
        }

        return result;
    }
}
