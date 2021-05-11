package com.cryallen.leetcode.easy.array;

import java.math.BigInteger;

/***
 * 7.整数反转
 * @author Allen
 * @DATE 2020-06-09
 ***/
public class Easy_7_IntegerReverse {

    /**
     * 整数反转
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-integer/
     * </p>
     *
     * <p>
     * 描述：
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * </p>
     *
     * <p>
     * 解答：暴力遍历，寻找目标元素
     * </p>
     */
    public static void main(String[] args) {
        int number1 =123;
        int reverseNum1 = reverseInteger(number1);
        System.out.println("reverseNum1 value:" + reverseNum1);

        int number2 =-12032;
        int reverseNum2 = reverseInteger(number2);
        System.out.println("reverseNum2 value:" + reverseNum2);

        int number3 =1534236469;
        int reverseNum3 = reverseInteger(number3);
        System.out.println("reverseNum3 value:" + reverseNum3);

        int number4 =1534236469;
        int reverseNum4 = intReverse(number4);
        System.out.println("reverseNum4 value:" + reverseNum4);

        int number5 =1534236469;
        int reverseNum5 = reverseByChar(number5);
        System.out.println("reverseNum5 value:" + reverseNum5);

    }


    /**
     * 整数反转实现1
     * 将整数转为数组，通过数组的角标来实现反转，再将数组最终转为int类型（数组–>String–>Integer）
     * */
    public static int intReverse(int x) {
        char[] charArray = Integer.toString(x).toCharArray();
        int length = charArray.length;
        System.out.println("intReverse length:" + length);
        char temp=0;
        if(x>0){
            int z=0, y=charArray.length-1;
            while(z < charArray.length/2){
                temp = charArray[z];
                charArray[z] = charArray[y];
                charArray[y] = temp;
                z++;
                y--;
            }
        }
        else{
            int z=1,y=charArray.length-1;
            while(z <= (charArray.length-1)/2){
                temp = charArray[z];
                charArray[z] = charArray[y];
                charArray[y] = temp;
                z++;
                y--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charArray.length;i++){
            sb.append(charArray[i]);
        }
        int res = 0;
        try{
            res = Integer.parseInt(sb.toString());
        }catch(Exception e){
        }
        return res;
    }

    /**
     * 整数反转实现2
     * 将整数转为数组，通过数组循环，进行字符串拼接，对于负数进行特殊处理
     * */
    public static int reverseByChar(int number) {
        //第一步：转换为字符数组
        char[] charArray = Integer.toString(number).toCharArray();
        int length = charArray.length;
        boolean isNegative = false;
        System.out.println("intReverse length:" + length);
        StringBuilder sb = new StringBuilder();
        //第二步：字符循环进行解析
        for (int i = length-1; i >= 0;i--){
            char charString = charArray[i];
            //第三步：判断是否为负数
            if(String.valueOf(charString).equals("-")){
                isNegative = true;
                continue;
            }
            System.out.println("intReverse charString:" + charString);
            sb.append(charString);
        }
        //第四步：字符组装
        String sbStr = sb.toString();
        System.out.println("intReverse sbStr:" + sbStr);
        if(isNegative){
            sbStr = "-" + sbStr;
        }
        System.out.println("intReverse new sbStr:" + sbStr);
        //第五步：返回结果
        int result = 0;
        try{
            result = Integer.parseInt(sbStr);
        }catch(Exception e){
        }
        return result;
    }

    /**
     * 整数反转实现3
     * 思路：不断模10取得最低位，再不断乘10相加得到最终的反转结果
     * */
    public static int reverseInteger(int x) {
        int res = 0;
        System.out.println("reverseInteger x:" + x);
        while (x != 0) {
            //第一步：进行数字求余
            int temp = res * 10 + x % 10;
            System.out.println("reverseInteger temp:" + temp);
            x = x / 10; //不断取前几位
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
            System.out.println("reverseInteger res:" + res);
        }
        return res;
    }


    /** *
     * @Description: 十进制转换成二进制
     * @param decimalSource
     * @return String */
    public static String decimalToBinary(int decimalSource) {
        //转换成BigInteger类型，默认是十进制
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        //参数2指定的是转化成二进制
        return bi.toString(2);
    }

    /**
     * @Description: 二进制转换成十进制
     * @param binarySource
     * @return int
     * */
    public static int binaryToDecimal(String binarySource) {
        //转换为BigInteger类型，参数2指定的是二进制
        BigInteger bi = new BigInteger(binarySource, 2);
        //默认转换成十进制
        return Integer.parseInt(bi.toString());
    }

    /**
     * @Description: 向左移位
     * @param num-等待移位的十进制数, m-向左移的位数
     * @return int-移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @Description: 向右移位
     * @param num-等待移位的十进制数, m-向右移的位数
     * @return int-移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }
}
