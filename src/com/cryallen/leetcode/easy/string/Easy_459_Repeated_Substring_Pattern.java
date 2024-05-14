package com.cryallen.leetcode.easy.string;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/14 20:55
 * Description ：Easy_541_Reverse_String_II
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_459_Repeated_Substring_Pattern {

    /**
     * 459. 重复的子字符串
     *
     * <p>
     * 地址：https://leetcode.cn/problems/repeated-substring-pattern/description/
     * </p>
     *
     * <p>
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     *
     * 示例 1:
     *
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * 示例 2:
     *
     * 输入: s = "aba"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 由小写英文字母组成
     */

    public static void main(String[] args) {
        String testStr = "abab";
        repeatedSubstringPattern(testStr);
        System.out.println(testStr);
    }

    /**
     * 暴力破解法
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s){
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
