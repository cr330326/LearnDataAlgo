package com.cryallen.leetcode.easy.shl;

import java.util.*;
import java.lang.*;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.shl
 * @date ： 2024/5/14 10:42
 * Description ：ShlTest
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class ShlTest {

    /**
     * next() 与 nextLine() 区别
     * next():
     *
     * 1、一定要读取到有效字符后才可以结束输入。
     * 2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
     * 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
     * next() 不能得到带有空格的字符串。
     *
     * nextLine()：
     *
     * 1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
     * 2、可以获得空白。
     */
    public static void main(String[] args){
       /* Scanner sc = new Scanner(System.in);
        System.out.println("next方式接收:");*/

       /* if(sc.hasNext()){
            String str1 = sc.next();
            System.out.println("输入的数据为:" + str1);
            shl01(str1);
        }*/

        //String input1 = sc.nextLine();
        //test:abc123!@#
        //shl01(input1);

        //输入字符串处理


        //testMathSqrt();
        //testBasicType();

       /* String input = "Hello123 World! #$%";
        int count1 = shl02(input);
        System.out.println("字符串中不属于数字、字母或空格的字符个数: " + count1);

        // 示例列表
        List<Integer> list1 = new ArrayList<>();
        list1.add(44);
        list1.add(1111);
        list1.add(3333);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1111);
        list2.add(2222);
        list2.add(3333);

        int count2 = countUniqueElements(list1, list2);
        System.out.println("不同时属于两个列表的元素的个数: " + count2);*/
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean result = rotation003(s1,s2);
        System.out.println("字符串轮转结果: " + result);
    }

    /**
     * 处理Number和Math方法
     */
    private static void testMathSqrt(){
        double x = 11.635;
        double y = 2.76;

        System.out.printf("e 的值为: %.4f%n",Math.E);
        System.out.printf("sqrt(%.3f 为 %.3f%n)",x,Math.sqrt(x));

        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
        int rand_int2 = rand.nextInt(1000);

        // Print random integers
        System.out.println("Random Integers: "+rand_int1);
        System.out.println("Random Integers: "+rand_int2);
    }

    /**
     * 处理基本类型
     */
    private static void testBasicType(){
        //字符串数组遍历输出
        String testStr = "e,t,a,tsee";
        String[] testArray = testStr.split(",");
        Arrays.sort(testArray);
        List<String> testList = Arrays.asList(testArray);

        for(String s: testList){
            System.out.println("test list str:" + s);
        }

        //字符数组组装为字符串打印
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        System.out.println( helloString );

        //返回子字符串
        String Str = new String("This is text");
        System.out.print("返回值 :" );
        System.out.println(Str.substring(4) );

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4, 10) );

        //处理字符串遍历打印输出
        StringBuilder sb = new StringBuilder();
        sb.append("test122323");
        int i = 0;
        while (i < sb.length()){
            char c = sb.charAt(i);
            System.out.println(c);
            i++;
        }

        //处理Character封装类
        char ch = 'a';
        Character characterA = new Character('a');
        System.out.println(characterA);



    }

    /**
     * 解法1-编号001 题目
     * 输入一个字符串，输出字符串中不属于数字，字母，空格的个数，循环遍历输出
     * 序号	方法与描述
     * 1	isLetter() 是否是一个字母
     * 2	isDigit() 是否是一个数字字符
     * 3	isWhitespace() 是否是一个空白字符
     * 4	isUpperCase() 是否是大写字母
     * 5	isLowerCase() 是否是小写字母
     * 6	toUpperCase() 指定字母的大写形式
     * 7	toLowerCase() 指定字母的小写形式
     * 8	toString() 返回字符的字符串形式，字符串的长度仅为1
     */
    private static void shl01(String str1){
        for (char c : str1.toCharArray()) {
            if (!Character.isAlphabetic(c) &&!Character.isWhitespace(c) &&!Character.isDigit(c)) {
                System.out.println(c);
            }
        }

       /* String reg = "\\W*";   //\w获取字母和数字 \W排除字母和数字 \s匹配任何空白字符，包括空格、制表符、换页符等等 \S匹配任何非空白字符
        String str = "abc 123!@#";

        char[] c1 = str.toCharArray();

        Pattern pattern=  Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            sb.append(matcher.group());
        }

        int i = 0;
        while (i < sb.length()){
            char c = sb.charAt(i);
            System.out.println(c);
            i++;
        }*/
    }

    public static int shl02(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 检查字符是否不是数字、字母或空格
            if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 解法1-编号002 题目
     * 第二道题是给两个列表，输出不同时属于两个列表的个数 例
     * 44
     * 1111
     * 2222
     * 输出8，因为 列表的元素都不同时存在两个列表中
     * 解题思路：
     * 我们分别遍历了两个列表，并对每个元素进行了检查。如果一个元素只在一个列表中出现，我们就增加计数器的值。
     * 这样，我们就能够计算出所有不同时存在于两个列表中的元素的总数（包括重复的元素）。
     */
    public static int countUniqueElements(List<Integer> list1, List<Integer> list2) {
        // 初始化计数器
        int count = 0;

        // 遍历第一个列表，检查元素是否在第二个列表中不存在
        for (int num : list1) {
            if (!list2.contains(num)) {
                count++;
            }
        }

        // 遍历第二个列表，检查元素是否在第一个列表中不存在
        // 注意这里不能直接使用 count += list2.size() - count，因为可能存在重复元素
        for (int num : list2) {
            if (!list1.contains(num)) {
                count++;
            }
        }

        return count;
    }


    /**
     * 解法2-编号002 题目
     * 第二道题是给两个列表，输出不同时属于两个列表的个数 例
     * 44
     * 1111
     * 2222
     * 输出8，因为 列表的元素都不同时存在两个列表中
     * 解题思路：
     * 首先创建了两个集合，分别用于存储列表中的元素。
     * 然后，将两个集合的元素合并成一个新的集合，接着保留两个集合的交集，
     * 最后计算合并后的集合中元素的数量减去交集中元素的数量，即为不同的元素数量。
     */
    public static int countDifferentElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        Set<Integer> difference = new HashSet<>(set1);
        difference.addAll(set2); // 将两个集合的元素合并
        set1.retainAll(set2); // 保留两个集合的交集

        return difference.size() - set1.size();
    }


    /**
     * 解法1-编号003 题目
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
     */
    private static boolean rotation003(String firstStr,String secondStr) {
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

    /**
     * 解法2-编号003 题目
     * 面试题 01.09. 字符串轮转
     */
    private static boolean rotation004(String firstStr,String secondStr) {
        return firstStr.length() == secondStr.length() && (firstStr + firstStr).contains(secondStr);
    }
}
