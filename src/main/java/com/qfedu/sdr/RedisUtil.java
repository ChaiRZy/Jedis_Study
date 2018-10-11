package com.qfedu.sdr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *@Author feri
 *@Date Created in 2018/10/11 09:51
 * 基于Spring Data Redis
 */
public class RedisUtil {

    private RedisTemplate<String,String> redisTemplate;

    public RedisUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //新增
    public void saveStr(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
    public void saveList(String key,String... values){
        redisTemplate.opsForList().rightPushAll(key,values);
    }
    public void saveHash(String key,String field,String value){
        redisTemplate.opsForHash().put(key,field,value);
    }
    //删除
    public void del(String key){
        redisTemplate.delete(key);
    }
    public void delList(String key,int count,String value){
        redisTemplate.opsForList().remove(key,count,value);
    }

    //查询
    public String getStr(String key){
        return redisTemplate.opsForValue().get(key);

    }
    public String getHash(String key,String field){
        return (String) redisTemplate.opsForHash().get(key,field);
    }
    public Map<Object, Object> getHashAll(String key){
        return redisTemplate.opsForHash().entries(key);
    }
    //系统
    public boolean isExists(String key){
        return redisTemplate.hasKey(key);
    }
    public void expire(String key, TimeUnit timeUnit,long times){
        redisTemplate.expire(key,times,timeUnit);
    }




}
