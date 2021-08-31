package com.cryallen.leetcode.easy.swordoffer.offer1;

/***
 * No1，实现内部静态类Singleton模式，线程安全用法
 * @author Allen
 * @DATE 2021-06-08
 ***/
public class Singleton3 {

    /**
     * 私有构造函数
     */
    private Singleton3(){}

    /**
     * 公有获取单例对象函数
     * @return
     */
    public static Singleton3 getInstance(){
        return Singleton3.Holder.instance;
    }

    private static class Holder{
        public static final Singleton3 instance = new Singleton3();
    }

}
