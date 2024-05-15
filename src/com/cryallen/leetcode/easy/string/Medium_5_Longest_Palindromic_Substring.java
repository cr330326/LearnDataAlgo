package com.cryallen.leetcode.easy.string;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/15 22:23
 * Description ：Medium_5_Longest_Palindromic_Substring
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Medium_5_Longest_Palindromic_Substring {

    /**
     * 5. 最长回文子串
     *
     * <p>
     * 地址：https://leetcode.cn/problems/longest-palindromic-substring/description/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一个字符串 s，找到 s 中最长的回文子串
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     *
     * </p>
     */
    public static void main(String[] args){
        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println("最长回文子串：" + longestPalindrome); // 输出："bab" 或者 "aba"
    }


    /**
     * 暴力方式
     * 这个解法的思路是枚举所有可能的子串，然后判断每个子串是否是回文串，并记录下最长的回文子串。
     * 虽然这种解法比较直观，但其时间复杂度为 O(n^3)，对于较长的字符串效率较低。
     *
     * </p>
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int maxLength = 0;
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (isPalindrome(substr) && substr.length() > maxLength) {
                    maxLength = substr.length();
                    longestPalindrome = substr;
                }
            }
        }
        return longestPalindrome;
    }

    // 判断一个字符串是否是回文串
    private static boolean isPalindrome(String s) {
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

    /**
     * 这个解法首先遍历字符串，以每个字符或者每两个字符之间的间隙作为中心，向两边扩展，找到以当前字符或者当前字符和下一个字符之间的间隙为中心的最长回文子串。
     * 然后，比较所有找到的回文子串，找到最长的回文子串，并返回。
     *
     * </p>
     */
    public String longestPalindromeByCenter(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以当前字符为中心扩展
            int len1 = expandAroundCenter(s, i, i);
            // 以当前字符和下一个字符之间的间隙为中心扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 更新最长回文子串的起始位置和结束位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 以指定位置为中心向两边扩展，返回回文串的长度
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

