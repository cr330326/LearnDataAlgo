package com.cryallen.leetcode.easy.hand;

import java.util.*;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.sort
 * @date ： 2024/5/17 18:04
 * Description ：BubbleSortSolution
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class BubbleSortSolution {

    /**
     * 程序入口函数
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        String[] inputArrayStr = inputStr.split(",");
        int[] inputArray = new int[inputArrayStr.length];
        for(int i = 0; i < inputArrayStr.length; i++) {
            inputArray[i] = Integer.valueOf(inputArrayStr[i]);
        }

        //执行冒泡排序算法
        int[] resultArray = bubbleSort(inputArray);
        for(int j = 0; j < resultArray.length; j++){
            System.out.println(resultArray[j]);
        }
    }

    /**
     * 冒泡排序算法
     */
    public static int[] bubbleSort(int[] inputArray){
        int[] resultArray = Arrays.copyOf(inputArray,inputArray.length);

        //外部控制循环次数
        for(int i = 0; i < resultArray.length -1; i++){
            //设定一个标记，若为true, 则表示此次循环有进行交换，为false，则表示此次循环没有进行交换，待排序已经是有序，无须额外排序
            boolean flag = false;

            //每一次循环，前后两个值进行两两判断比对，如果前一位值比后一位值大，则进行两两交换
            for(int j = 0; j < resultArray.length - i -1; j++){
                if(resultArray[j] > resultArray[j + 1]){
                    int temp = resultArray[j];
                    resultArray[j] = resultArray[j + 1];
                    resultArray[j + 1] = temp;
                    flag = true;
                }
            }

            //代表排序已经完毕
            if(!flag){
                break;
            }
        }

        //结果返回
        return resultArray;
    }
}
