package com.qfedu.redis;

import redis.clients.jedis.Jedis;

/**
 *@Author feri
 *@Date Created in 2018/10/10 16:08
 */
public class Jedis_Main {
    public static void main(String[] args) {
        //1、创建客户端对象并指定主机和端口
        Jedis jedis=new Jedis("10.8.164.91",6370);
        //2、设置密码
        jedis.auth("qfjava");
        jedis.connect();
        //3、使用
        //设置内容  String
        jedis.set("s1","Jedis");
        //获取内容 String
        String res=jedis.get("s1");
        System.out.println("结果："+res);
        //操作list
        jedis.lpush("list1","111","222");
        String r=jedis.lpop("list1");
        System.out.println("pop:"+r);

        //4、释放
        jedis.close();
    }
}
