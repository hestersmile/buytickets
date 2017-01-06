package com.myredis;

import redis.clients.jedis.Jedis;

/**
 * Created by hestersmile on 2017/1/2.
 */
public class JedisClientSingimp implements JedisClient {

    //    @Autowired
    private InitRedisClient initRedisClient = new InitRedisClient();
    private Jedis jedis = initRedisClient.getJedis();

    @Override
    public String get(String key) {
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    @Override
    public String set(String key, String value) {
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    @Override
    public String hget(String hkey, String key) {
        String string = jedis.hget(hkey, key);
        System.out.print(string);
        jedis.close();
        return string;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }

    @Override
    public long incr(String key) {
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public long expire(String key, int second) {
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    @Override
    public long ttl(String key) {
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

}
