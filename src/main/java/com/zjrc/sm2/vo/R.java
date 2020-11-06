package com.zjrc.sm2.vo;

import lombok.Data;

/**
 * @program:
 * @description:
 * @author: ErBa(韩智飞)
 * @create: 2020-09-14 11:01
 */
@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    //
    public static R setR(int code,String msg,Object data){
        R r=new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    //成功
    public static R ok(){
        return setR(200,"OK",null);
    }
    public static R ok(Object data){

        return setR(200,"OK",data);
    }
    //失败
    public static R fail(){

        return setR(400,"Fail",null);
    }
    public static R fail(String msg){

        return setR(400,msg,null);
    }
}
