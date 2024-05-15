package com.cryallen.leetcode.easy.string;

import java.util.Scanner;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/15 21:51
 * Description ：Medium_647_Palindromic_Substrings
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Medium_647_Palindromic_Substrings {

    /**
     * 647. 回文子串
     *
     * <p>
     * 地址：https://leetcode.cn/problems/palindromic-substrings/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     * 示例 1：
     *
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由小写英文字母组成
     *
     * </p>
     */

    public static void main(String[] args){
        String s = "abc";
        int count = countSubstrings(s);
        System.out.println("回文子串的数目：" + count); // 输出：3
    }

    /**
     * 暴力解法的思路是枚举所有可能的子串，并检查每个子串是否是回文串。回文串是指正着读和倒着读都一样的字符串。
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int count = 0;
        // 枚举所有可能的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // 检查子串是否是回文串
                if (isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    // 判断字符串是否是回文串
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int countSubstringsByCenter(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以当前字符为中心扩展
            count += extendPalindromeByCenter(s, i, i);
            // 以当前字符和下一个字符之间的间隙为中心扩展
            count += extendPalindromeByCenter(s, i, i + 1);
        }
        return count;
    }


    // 以指定位置为中心向两边扩展，统计回文串的数量
    private int extendPalindromeByCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

