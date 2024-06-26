package com.cryallen.leetcode.easy.swordoffer.offer1;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.swordoffer.offer1
 * @date ： 2024/6/26 14:51
 * Description ：Singleton4 枚举方式实现
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public enum Singleton4 {

    INSTANCE;

    public static Singleton4 getInstance(){
        return INSTANCE;
    }
}
