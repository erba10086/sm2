package com.zjrc.sm2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: sm2
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-11-06 08:41
 **/
@Data
@AllArgsConstructor
public class Bank {
    private String name;
    private String money;
}
