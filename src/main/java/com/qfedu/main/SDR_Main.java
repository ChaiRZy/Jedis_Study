package com.qfedu.main;

import com.qfedu.redis.JedisUtil;
import com.qfedu.sdr.RedisUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@Author feri
 *@Date Created in 2018/10/11 10:17
 */
public class SDR_Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
        JedisUtil jedisUtil=context.getBean("jedisUtil",JedisUtil.class);
        RedisUtil redisUtil=context.getBean("redisUtil",RedisUtil.class);
        System.out.println(jedisUtil);
        System.out.println(redisUtil);
        jedisUtil.addHash("h1","id","1111");
        jedisUtil.addList("list1","1111");
        System.err.println("Jedis:"+jedisUtil.getListAll("list1"));

        redisUtil.saveHash("hash2","name","张三");
        System.err.println("SDR:"+redisUtil.getHash("hash2","name"));

    }
}
