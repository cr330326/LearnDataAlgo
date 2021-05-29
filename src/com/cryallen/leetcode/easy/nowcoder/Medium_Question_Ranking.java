package com.cryallen.leetcode.easy.nowcoder;

import java.util.HashMap;

/***
 * 最长无重复子数组
 * @author Allen
 * @DATE 2021-5-29
 ***/
public class Medium_Question_Ranking {

    /**
     * 最长无重复子数组
     *
     * <p>
     * 地址：https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=190&&tqId=35220&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
     * </p>
     *
     * <p>
     * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     *
     * 示例 1:
     输入：
     [2,3,4,5]
     返回值：
     4
     说明：
     [2,3,4,5]是最长子数组

     思路：
     题解1:可以用两个指针实现
     1.i,j两个指针指向起始元素，j指针依次后移，把扫描过的元素放入map中，
     j指针一直后移直到遇到重复元素，顺便记录一个最大值max，
     2.如果遇到重复元素，则将i指针指向该元素，之后的比较max（i，j-i+1）

     复制代码
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,4,5};
        int result1 = maxLength(nums1);
        System.out.println("result1: " + result1);
    }

    /**
     *题解1:可以用两个指针实现
     *1.i,j两个指针指向起始元素，j指针依次后移，把扫描过的元素放入map中，
     *j指针一直后移直到遇到重复元素，顺便记录一个最大值max，
     *2.如果遇到重复元素，则将i指针指向该元素，之后的比较max（i，j-i+1）
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength (int[] arr) {
        if(arr.length == 0) return 0;
        int max=0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0,j=0;j < arr.length;j++){
            //如果有重复元素，改变i指针
            if(map.containsKey(arr[j])){
                i = Math.max(i,map.get(arr[j]) + 1);
            }
            map.put(arr[j],j);
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}
