package com.zjrc.sm2.test;

import com.zjrc.sm2.third.RedissonUtil;

import java.util.HashMap;

/**
 * @program: sm2
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-11-06 12:08
 **/
public class Test1 {
    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(RedissonUtil.getStr(null));
    }
}
