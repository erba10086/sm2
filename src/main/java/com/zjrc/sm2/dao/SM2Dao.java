package com.zjrc.sm2.dao;

public interface SM2Dao {

    boolean selectByIp(String ip);

    int insertIp(String ip);
}
