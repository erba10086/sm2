package com.zjrc.sm2.third;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @version 1.0
 * @date 2020/10/4 10:06
 */
public class RedissonUtil {
    private static String host="59.110.227.223";
    private static int port=6379;
    private static String pass="188389han";
    private static RedissonClient client;
    static {
        Config config=new Config();
        config.useSingleServer().setPassword(pass).setAddress("redis://"+host+":"+port);
        client= Redisson.create(config);
    }

    //新增
    public static void addStr(String key,Object val){
        client.getBucket(key).set(val);
    }
    public static void addStrTime(String key,Object val,int seconds){
        client.getBucket(key).set(val,seconds, TimeUnit.SECONDS);
    }
    public static void addHash(String key,String field,Object data){
        client.getMap(key).put(field,data);
    }


    //查询
    public static Object getStr(String key){
        return client.getBucket(key).get();
    }
    public static Object getHash(String key,String field){
        return client.getMap(key).get(field);
    }
    public static Collection<Object> getHashVals(String key){
        return client.getMap(key).readAllValues();
    }
    public static Map<Object,Object> getHashAll(String key){
        return client.getMap(key).readAllMap();
    }
    //校验
    public static boolean checkKey(String key){
        return client.getKeys().countExists(key)>0;
    }
    public static boolean checkHashField(String key,String f){
        return client.getMap(key).containsKey(f);
    }
    //删除Key
    public static boolean delKey(String... key){
        return client.getKeys().delete(key)>0;
    }
    public static boolean delField(String key,String field){
        return client.getMap(key).remove(field)!=null;
    }
}
