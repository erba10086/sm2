package com.zjrc.sm2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: sm2
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-11-06 08:56
 **/
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;
}
