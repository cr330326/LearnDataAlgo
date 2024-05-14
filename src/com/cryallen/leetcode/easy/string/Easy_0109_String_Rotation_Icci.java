package com.cryallen.leetcode.easy.string;
import java.util.*;
import java.lang.*;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.string
 * @date ： 2024/5/14 14:02
 * Description ：Easy_0109_String_Rotation_Icci
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Easy_0109_String_Rotation_Icci {

    /**
     * 面试题 01.09. 字符串轮转
     *
     * <p>
     * 地址：https://leetcode.cn/problems/string-rotation-lcci/description/
     * </p>
     *
     * <p>
     * 描述：
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     *
     * 示例1:
     *
     *  输入：s1 = "waterbottle", s2 = "erbottlewat"
     *  输出：True
     * 示例2:
     *
     *  输入：s1 = "aa", s2 = "aba"
     *  输出：False
     * 提示：
     *
     * 字符串长度在[0, 100000]范围内。
     * 说明:
     *
     * 你能只调用一次检查子串的方法吗？
     * </p>
     *
     * <p>
     *
     * </p>
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        System.out.println("待输入字符串1：" + input1);

        String input2 = sc.nextLine();
        System.out.println("待输入字符串2：" + input2);

        boolean result = rotation(input1,input2);
        System.out.println("处理结果值：" + result);
    }

    private static boolean rotation(String firstStr,String secondStr) {
        if(firstStr.equals(secondStr)){
            return true;
        }

        int firstLength = firstStr.length();
        int secondLength = secondStr.length();
        if(firstLength == 0 || firstLength > 1000000){
            System.out.println("第一个输入字符串为空或超出长度");
            return false;
        }

        if(secondLength == 0 || secondLength > 1000000){
            System.out.println("第二个输入字符串为空或超出长度");
            return false;
        }

        for(int i = 0; i < firstLength; i++){
            String leftStr = firstStr.substring(0,i);
            String rightStr = firstStr.substring(i,firstLength);
            if(secondStr.equals(rightStr + leftStr)){
                return true;
            }
        }
        return false;
    }


}
