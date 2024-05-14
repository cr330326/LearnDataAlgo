package com.cryallen.leetcode.easy.string;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/14 18:03
 * Description ：Easy_344_Reverse_string
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_344_Reverse_String {

    /**
     * 344. 反转字符串
     *
     * <p>
     * 地址：https://leetcode.cn/problems/reverse-string/description/
     * </p>
     *
     * <p>
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     示例 1：

     输入：s = ["h","e","l","l","o"]
     输出：["o","l","l","e","h"]
     示例 2：

     输入：s = ["H","a","n","n","a","h"]
     输出：["h","a","n","n","a","H"]


     提示：

     1 <= s.length <= 105
     s[i] 都是 ASCII 码表中的可打印字符
     */

    public static void main(String[] args) {
      /*  char[] testChar = new char[]{'h','e','l','l','o'};
        System.out.println(testChar);
        reverseString(testChar);
        System.out.println(testChar);*/

        char[] testChar1 = new char[]{'H','a','n','n','a','h'};
        System.out.println(testChar1);
        reverseString(testChar1);
        System.out.println(testChar1);
    }

    /**
     * 暴力破解思路
     * @param s
     * @return
     */
    private static void reverseStringAll(char[] s){
        int length = s.length;
        if(s.length <= 1 || s.length >= 105){
            return;
        }
        int start = 0;
        char[] result = new char[length];
        for(int i = length-1; i >= 0; i--){
            result[start++] = s[i];
        }
        System.out.println(result);
    }

    /**
     * 双指针思路
     * @param s
     * @return
     */
    private static void reverseString(char[] s){
        int length = s.length;
        if(s.length <= 1 || s.length >= 105){
            return;
        }
        for(int start = 0,end = length -1; start < end; ++start,--end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
    }
}
