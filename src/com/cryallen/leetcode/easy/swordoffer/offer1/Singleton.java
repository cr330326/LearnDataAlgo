package com.cryallen.leetcode.easy.swordoffer.offer1;

/***
 * No1，实现Singleton模式，线程不安全用法
 * @author Allen
 * @DATE 2021-06-08
 ***/
public class Singleton {

    /**
     * 私有静态变量
     */
    private static Singleton singleton;

    /**
     * 私有构造函数
     */
    private Singleton(){}

    /**
     * 公有获取单例对象函数
     * @return
     */
    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
