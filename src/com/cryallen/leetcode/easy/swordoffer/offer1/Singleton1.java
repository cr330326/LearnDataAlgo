package com.cryallen.leetcode.easy.swordoffer.offer1;

/***
 * No1，实现饿汉式Singleton模式，线程不安全用法
 * @author Allen
 * @DATE 2021-06-08
 ***/
public class Singleton1 {

    /**
     * 私有静态变量
     */
    private static Singleton1 singleton1 = new Singleton1();

    /**
     * 私有构造函数
     */
    private Singleton1(){}

    /**
     * 公有获取单例对象函数
     * @return
     */
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
