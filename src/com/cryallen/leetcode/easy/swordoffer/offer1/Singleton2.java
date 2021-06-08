package com.cryallen.leetcode.easy.swordoffer.offer1;

/***
 * No1，实现懒汉式双重校验锁Singleton模式，线程安全用法
 * @author Allen
 * @DATE 2021-06-08
 ***/
public class Singleton2 {

    /**
     * 私有静态变量
     */
    private static volatile Singleton2 singleton2;

    /**
     * 私有构造函数
     */
    private Singleton2(){}

    /**
     * 公有获取单例对象函数
     * @return
     */
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
