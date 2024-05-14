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
public class Easy_541_Reverse_String_II {

    /**
     * 541. 反转字符串
     *
     * <p>
     * 地址：https://leetcode.cn/problems/reverse-string-ii/description/
     * </p>
     *
     * <p>
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     *
     示例 1：

     输入：s = "abcdefg", k = 2
     输出："bacdfeg"
     示例 2：

     输入：s = "abcd", k = 2
     输出："bacd"


     提示：

     1 <= s.length <= 104
     s 仅由小写英文组成
     1 <= k <= 104
     */

    public static void main(String[] args) {
        String testStr = "abcdefg";
        System.out.println(reverseStr(testStr,2));
    }

    /**
     * 解法二（似乎更容易理解点）
     * 题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
     * @param s
     * @return
     */
    public static String reverseStr(String s,int k){
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
