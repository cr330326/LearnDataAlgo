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
      /*  Scanner sc = new Scanner(System.in);
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
      /*  String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean result = rotation003(s1,s2);
        System.out.println("字符串轮转结果: " + result);*/
        //testBasicType();
        //testConvert();
        testBitOperation();
        //testCollectionSort();
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
        String testStr11 = "e,t,a,tsee";

        testStr.equals(testStr11);
        testStr.equalsIgnoreCase(testStr11);

        int length = testStr.length();
        System.out.println("test str length:" + length);
        int result = testStr.compareTo(testStr11);
        System.out.println("test str result:" + result);

        String[] testArray = testStr.split(",");
        Arrays.sort(testArray);
        List<String> testList = Arrays.asList(testArray);
        for(String s: testList){
            System.out.println("test list str:" + s);
        }

        for(int k= 0; k < testList.size(); k++){
            System.out.println("test list str:" + testList.get(k));
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

        //处理字符串为空输入
        String testNumStr = "2 3 4";
        String[] testNumStrArray = testNumStr.split("\\s");
        for(int j = 0; j < testNumStrArray.length; j++){
            System.out.println("test num:" + testNumStrArray[j]);
        }
    }

    /**
     * 处理数据装换
     */
    private static void testConvert(){
        //double -> int
        double x = 11.635;
        System.out.println("double x: "+x);
        Double testDouble1 = new Double(x);
        int testIntValue1 = testDouble1.intValue();
        System.out.println("int testIntValue1: "+testIntValue1);
        int testDouble2 = (int) x;
        System.out.println("int testDouble2: "+testDouble2);

        //int -> double
        int y = 11;
        System.out.println("int y: "+y);
        Double testDouble3 = new Double(y);
        double testDoubleValue1 = Double.valueOf(testDouble3);
        System.out.println("double testDoubleValue1: "+testDoubleValue1);
        double testDoubleValue2 = y;
        System.out.println("double testDoubleValue2: "+testDoubleValue2);

        //string -> int
        String numberStr = "343434";
        System.out.println("string numberStr: "+numberStr);
        Integer testStrNum = Integer.valueOf(numberStr);
        int testNumValue = testStrNum.intValue();
        System.out.println("int testNumValue: "+testNumValue);

        //int -> string
        int number = 343434;
        System.out.println("int number: "+number);
        String numberStrValue = String.valueOf(number);
        System.out.println("numberStrValue:" + numberStrValue);

        //String -> float
        String floatStr = "3.14f";
        System.out.println("string floatStr: "+floatStr);
        Float testStrFloat = Float.valueOf(floatStr);
        float testFloatValue = testStrFloat.floatValue();
        System.out.println("float testFloatValue: "+testFloatValue);

        //float -> String
        float floatTest = 3.14f;
        System.out.println("float floatTest: "+floatTest);
        String floatTestValueStr = String.valueOf(floatTest);
        System.out.println("floatTestValueStr: "+floatTestValueStr);
    }

    /**
     * 位运算操作
     */
    private static void testBitOperation(){
        int t1 = 5; //二进制 5 = 101
        System.out.println("t1 二进制: "+ Integer.toBinaryString(t1));
        int t2 = 3; //二进制 3 = 011
        System.out.println("t2 二进制: "+ Integer.toBinaryString(t2));

        //按位与运算符(&)的作用是将操作数的每个对应位都进行与运算，结果位的值为1只有当两个操作数对应位都为1时才会出现
        int tt1 = t1 & t2;  // 结果为1
        System.out.println("tt1: "+ tt1);

        //按位或运算符(|)的作用是将操作数的每个对应位都进行或运算，结果位的值为1只要有一个操作数对应位为1就会出现
        int tt2 = t1 | t2;  // 结果为7
        System.out.println("tt2: "+ tt2);

        //按位异或运算符(^)的作用是将操作数的每个对应位都进行异或运算，结果位的值为1只有当两个操作数对应位不同才会出现
        int tt3 = t1 ^ t2;  // 结果为6
        System.out.println("tt3: "+ tt3);

        //按位取反运算符(~)的作用是将操作数的每个对应位都进行取反操作(0变成1，1变成0)
        int tt4 = ~t1;  // 结果为-6
        System.out.println("tt4: "+ tt4);

        //左移运算符(<<)的作用是将操作数的二进制位向左移动指定的位数，空位补0
        int tt5 = t1 << 2;  // 结果为20
        System.out.println("tt5: "+ tt5);

        //右移运算符(>>)的作用是将操作数的二进制位向右移动指定的位数，空位的值由符号位决定，正数补0，负数补1
        int tt6 = t1 >> 2;  // 结果为1
        System.out.println("tt6: "+ tt6);


        //位运算-左移
        int a = 4;
        System.out.println("原始值 a: "+a);
        a = a << 2; //左移2位，相当于乘以 2^2 结果为16
        System.out.println("左移2位之后 a: "+a);

        //位运算-右移
        int b = 8;
        System.out.println("原始值 b: "+b);
        b = b >> 2; //有符号-右移2位，相当于除以 2^2 结果为2
        System.out.println("有符号右移2位之后 b: "+b);
        int c = 16;
        c = c >>> 2; //无符号-右移2位，相当于除以 2^2 结果为4
        System.out.println("无符号右移2位之后 c: "+c);
    }

    /**
     * 集合排序
     */
    private static void testCollectionSort(){
        String testStr = "tesgabcdr";
        System.out.println("字符串原始值: "+ testStr);
        char[] charArray = testStr.toCharArray();
        //字符排序，默认是升序
        Arrays.sort(charArray);
        System.out.println("升序字符串值: "+ String.valueOf(charArray));

        Character[] characterArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            characterArray[i] = charArray[i];
        }
        //字符排序，降序
        Arrays.sort(characterArray,Collections.reverseOrder());
        System.out.println("降序字符串值: "+ String.valueOf(characterArray));
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

    /**
     * 解法1-编号004 题目-长度最小的子数组
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     * </p>
     *
     * <p>
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * 示例 1:
     输入：target = 7, nums = [2,3,1,2,4,3]
     输出：2
     解释：子数组 [4,3] 是该条件下的长度最小的子数组。

     *
     * 示例 2:
     输入：target = 4, nums = [1,4,4]
     输出：1

     *
     * 示例 3:
     输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     输出：0

     提示：

     1 <= target <= 109
     1 <= nums.length <= 105
     1 <= nums[i] <= 105

     方式1:暴力解法
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    ans = Math.min(ans,j - i + 1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 方式2: 滑动窗口方法
     * */
    public static int minSubArrayLenSlide(int target, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 编号005 题目
     * 鲍勃需要给他的密码加密，现在他有数值s，然后有个键值n和m，都是整数，密码规则是：s的n次平方取模10，得到一个结果，然后根据这个结果进行m次平方得到一个新的值，最终对这个新的值进行取模1000000007
     * (((s^n)%10)^m)%1000000007
     */
    public static int passwordSecret(int s,int n,int m) {
        return 0;
    }
}
