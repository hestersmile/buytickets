package com.controller;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by hestersmile on 2016/12/31.
 */
public class testredis {
    @Test
    public void testJedisSingle() {
        //创建一个jedis的对象。
        Jedis jedis = new Jedis("192.168.32.137", 6379);
        //调用jedis对象的方法，方法名称和redis的命令一致。
        jedis.set("key1", "jedis test");
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis。
        jedis.close();
    }

    /**
     * 使用连接池
     */
    @Test
    public void testJedisPool() {
        //创建jedis连接池
        JedisPool pool = new JedisPool("192.168.32.137", 6379);
        //从连接池中获得Jedis对象
        Jedis jedis = pool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis对象
        jedis.close();

    }

}
