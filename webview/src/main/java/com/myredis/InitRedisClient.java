package com.myredis;

import com.common.DefineData;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hestersmile on 2017/1/2.
 */
public class InitRedisClient {
    private static JedisPool pool;
    private static String host = DefineData.RedisPath;
    private static String pass=DefineData.RedisPassword;
    private static int port = 6379;
    private static int timeout = 30 * 1000;
    private static int maxIdle = 200;

    private static org.slf4j.Logger logger_ = org.slf4j.LoggerFactory
            .getLogger(InitRedisClient.class.getName());

    private static void initPool() {
        logger_.info("Init Redis Pool [{}]:[{}]", host, port);
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setTestOnBorrow(false);
        pool=new JedisPool(config,host,port,timeout,pass);
    }

    public static Jedis getJedis() {
        if (pool == null)
            initPool();
        return pool.getResource();
    }

    public void returnJedis(Jedis jedis) {
        if (jedis != null){}
           jedis.close();
    }
}
