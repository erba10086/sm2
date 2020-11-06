package com.zjrc.sm2.service.impl;

import com.zjrc.sm2.dao.SM2Dao;
import com.zjrc.sm2.entity.IpWhite;
import com.zjrc.sm2.service.intf.SMService;
import com.zjrc.sm2.third.RedissonUtil;
import com.zjrc.sm2.utils.JwtCore;
import com.zjrc.sm2.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: sm2
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-11-06 10:31
 **/
@Service
@Transactional
public class SMServiceImpl implements SMService {


    @Autowired
    private SM2Dao sm2Dao;


    @Override
    public R selectByIp(String ip, String token) {


        if (token == null || "".equals(token) || !RedissonUtil.checkKey("MG:" + ip) ||
                !RedissonUtil.getStr("MG:" + ip).equals(token)) {
            sm2Dao.insertIp(ip);

            String token1 = JwtCore.createToken("MG:" + ip);
            RedissonUtil.addStrTime("MG:" + ip,token1,60);
            // 处理业务逻辑
            return R.ok(token1);

        } else {
            return R.ok("处理逻辑");
        }

    }
}
