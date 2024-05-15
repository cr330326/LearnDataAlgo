package com.cryallen.leetcode.easy.shl;

import java.util.*;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.shl
 * @date ： 2024/5/15 20:43
 * Description ：ShlTest2
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class ShlTest2 {

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
      /*  Scanner scanner = new Scanner(System.in);
        // 输入天数 M
        int M = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 输入当前路灯状态
        String lightsStr = scanner.nextLine();

        // 计算 M 天后路灯的状态并输出
        String nextDayLights = calculateNextDayLights(M, lightsStr);
        System.out.println(nextDayLights);*/


        // 示例输入
        int M = 2; // 天数
        int[] lights = {1, 1, 1, 0, 1, 1, 1, 1}; // 初始路灯状态

        // 输出M天后的路灯状态
        int[] result = simulateLightsNew(M, lights);
        for (int light : result) {
            System.out.print(light + " ");
        }
    }

    /**
     * 编号007 题目
     *
     伍兹先生是一名电工，他位在门口八个路灯时出现了错误，这些连接是这样的，如果与某个灯相邻的路灯都亮(表示为1) 或青都灭 [表示为0)该路灯在第二晚熄灭。否则，第二天晚上仍然保持亮灯状态。
     道路端头的两个路灯只有一个相邻的路灯，所以男一相邻的路灯可认为一直是熄灭的。在特定的某一天，灯的状态视为次日而非当天的状态。
     由于这个错误，该市市民在夜间闲车将面临困难。因此，他们已经向相关部门就该情况进行了投诉。根据该投诉，该部门负责人索要M天后的路灯状态报

     写一个算法，输出给定的M天后路灯的
     输入的第一行包括一个整数一-
     表示天数(M)
     -days一行包括八个以空格分隔的整数，表示路灯的当前状态，即0或1。

     打印八个以空格分隔的整数
     ，表示M天

     2
     11101111
     输出:
     00000110
     解释
     位置0处的路灯相邻的路灯为0《假设)和1，所以，第二天，它将为1.
     位置1处的路灯相邻的路灯都为1:所以，第二天，它将为0
     位置2处的路灯相邻的路灯为0和1，所以，第二天，它将为1。
     位置3处的路灯为0，两个相邻路灯都力1，所以，第二天是0。位置3处的路灯只会
     同样，我们可以找出其余路灯第二天的状态
     所以，第一天之后的路灯状态是1010
     1001
     两天~之后，路灯的状态是0000011
     * */

    public static String calculateNextDayLights(int M, String lightsStr) {
        char[] lights = lightsStr.toCharArray();

        // 模拟 M 天后路灯的状态
        for (int i = 0; i < M; i++) {
            char[] nextDay = new char[8];
            for (int j = 0; j < 8; j++) {
                if (lights[j] == '0') {
                    // 路灯为 0，且相邻路灯都是 1，第二天该路灯将亮起
                    if ((j == 0 || lights[j - 1] == '1') && (j == 7 || lights[j + 1] == '1')) {
                        nextDay[j] = '1';
                    } else {
                        nextDay[j] = '0';
                    }
                } else {
                    // 路灯为 1，第二天该路灯将熄灭
                    nextDay[j] = '0';
                }
            }
            lights = nextDay;
        }

        // 将路灯状态转换为字符串并返回
        return new String(lights);
    }

    // 模拟路灯状态变化M天
    public static int[] simulateLights(int M, int[] lights) {
        // 复制一份初始状态，避免影响原始数组
        int[] currentState = lights.clone();

        for (int day = 0; day < M; day++) {
            // 创建一个新的数组来存储下一天的状态
            int[] nextState = new int[lights.length];

            // 遍历每个路灯
            for (int i = 0; i < lights.length; i++) {
                // 确定相邻路灯的状态
                int left = (i == 0) ? 0 : currentState[i - 1]; // 左边路灯的状态，如果是第一个则认为是0
                int right = (i == lights.length - 1) ? 0 : currentState[i + 1]; // 右边路灯的状态，如果是最后一个则认为是0

                // 根据规则更新路灯状态
                if (left == right) {
                    nextState[i] = 1 - currentState[i]; // 如果相邻路灯状态相同，则翻转当前路灯状态
                } else {
                    nextState[i] = currentState[i]; // 否则保持当前状态
                }
            }

            // 更新当前状态为下一天的状态
            currentState = nextState;
        }

        // 返回最后一天的状态
        return currentState;
    }

    // 模拟路灯状态变化M天
    public static int[] simulateLightsNew(int M, int[] lights) {
        // 直接在原始数组上修改状态
        for (int day = 0; day < M; day++) {
            int[] nextState = new int[lights.length];

            // 遍历每个路灯
            for (int i = 0; i < lights.length; i++) {
                // 确定相邻路灯的状态
                int left = (i == 0) ? 0 : lights[i - 1]; // 左边路灯的状态，如果是第一个则认为是0
                int right = (i == lights.length - 1) ? 0 : lights[i + 1]; // 右边路灯的状态，如果是最后一个则认为是0

                // 根据规则更新路灯状态
                if (left == right) {
                    nextState[i] = 1 - lights[i]; // 如果相邻路灯状态相同，则翻转当前路灯状态
                } else {
                    nextState[i] = lights[i]; // 否则保持当前状态
                }
            }

            // 更新当前状态为下一天的状态
            lights = nextState;
        }

        // 返回最后一天的状态
        return lights;
    }

    /**
     * 在 LeetCode 上，与最大回文序列（或回文子序列、回文子串）相关的题目有多个。以下是一些例子：
     *
     * 516. 最长回文子序列（Longest Palindromic Subsequence）：
     * 题目描述：给定一个字符串 s，找到其中最长的回文子序列，并返回该子序列的长度。
     * 解题思路：动态规划，dp[i][j] 表示字符串 s 的下标范围 [i, j] 内的最长回文子序列的长度。
     *
     * 5. 最长回文子串（Longest Palindromic Substring）：
     * 题目描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 解题思路：
     * 动态规划：dp[i][j] 表示 s[i:j+1] 是否为回文串。
     * 中心扩展法：遍历每个字符，以该字符或该字符和下一个字符作为中心，向外扩展，寻找最长回文子串。
     * Manacher's 算法（虽然 LeetCode 上不常用，但它是处理回文串问题的经典算法）。
     *
     * 647. 回文子串（Palindromic Substrings）：
     * 题目描述：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也被认为是不同的字符串。
     * 解题思路：与最长回文子串类似，但不需要找到具体的子串，只需要计数。可以使用动态规划或中心扩展法。
     *
     * 131. 回文分割（Palindrome Partitioning）：
     * 题目描述：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的所有可能的分割方案。
     * 解题思路：回溯法，尝试从每个位置开始分割，并递归处理剩余部分。
     *
     * 132. 回文分割 II（Palindrome Partitioning II）：
     * 题目描述：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的分割方案中最少分割次数。
     * 解题思路：动态规划，dp[i] 表示字符串 s[0:i+1] 的最少分割次数。
     * 以上题目都是与回文序列或回文子串相关的 LeetCode 题目。通过解决这些题目，你可以深入理解回文串问题的处理方法。
     */

    /**
     * 647. 回文子串
     *
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
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
     */

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

}
