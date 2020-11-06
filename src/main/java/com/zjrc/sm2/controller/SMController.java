package com.zjrc.sm2.controller;

import com.zjrc.sm2.entity.IpWhite;
import com.zjrc.sm2.entity.Result;
import com.zjrc.sm2.service.intf.SMService;
import com.zjrc.sm2.third.RedissonUtil;
import com.zjrc.sm2.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: sm2
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-11-06 09:40
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "测试ip")
public class SMController {

    @Autowired
    private SMService smService;

    @ApiOperation(value = "测试ip")
    @PostMapping("/test.do")
    public R test(@RequestBody Result result, HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        System.out.println(request.getHeader("abcd"));
        return smService.selectByIp(remoteAddr,request.getHeader("abcd"));


    }

    @ApiOperation(value = "校验token")
    @PostMapping("/test2.do")
    public R test1(String token,HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        if(!RedissonUtil.getStr("MG:" + remoteAddr).equals(token)) {
            return R.fail("no");
        }

        return R.ok("处理逻辑");
    }
}
