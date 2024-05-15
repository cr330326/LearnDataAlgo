package com.cryallen.leetcode.easy.string;

import java.util.Scanner;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/15 21:39
 * Description ：Medium_516_1
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Medium_516_Longest_Palindromic_Subsequence {

    /**
     * 516. 最长回文子序列
     *
     * <p>
     * 地址：https://leetcode.cn/problems/longest-palindromic-subsequence/description/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     *
     示例 1：

     输入：s = "bbbab"
     输出：4
     解释：一个可能的最长回文子序列为 "bbbb" 。
     示例 2：

     输入：s = "cbbd"
     输出：2
     解释：一个可能的最长回文子序列为 "bb" 。


     提示：

     1 <= s.length <= 1000
     s 仅由小写英文字母组成
     *
     * </p>
     */

    public static void main(String[] args){
        String s = "bbbab";
        int longestPalindromeSubseq = longestPalindromeSubseq(s);
        System.out.println("最长回文子序列的长度：" + longestPalindromeSubseq); // 输出：4
    }

    /**
     * 这个解法使用了动态规划的思想。
     * 首先，初始化所有长度为1的子序列为回文子序列，
     * 然后枚举所有可能的子序列长度，依次计算长度为2、3、...、n的子序列的最长回文子序列长度
     * 最终得到整个字符串的最长回文子序列长度。
     */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] 表示 s[i..j] 中最长回文子序列的长度
        int[][] dp = new int[n][n];
        // 初始化长度为1的子序列为回文子序列
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 枚举所有可能的子序列长度
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果两个字符相等，则最长回文子序列长度为内部子序列长度+2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 如果两个字符不相等，则最长回文子序列长度为两个内部子序列中较长的一个
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 整个字符串的最长回文子序列长度即为 dp[0][n-1]
        return dp[0][n - 1];
    }

    /**
     * 这个解法的思路是枚举所有可能的子序列，然后判断每个子序列是否是回文序列，并记录下最长的回文子序列的长度。
     * 虽然这种解法比较直观，但其时间复杂度较高，为 O(n^3)，对于较长的字符串效率较低。
     */
    public int longestPalindromeSubSeqByAll(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subsequence = s.substring(i, j);
                if (isPalindrome(subsequence)) {
                    maxLength = Math.max(maxLength, subsequence.length());
                }
            }
        }
        return maxLength;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

