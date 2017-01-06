package com.myredis;

/**
 * Created by hestersmile on 2017/1/2.
 */
public interface JedisClient {

    public String get(String key) ;

    public String set(String key, String value) ;

    public String hget(String hkey, String key);

    public long hset(String hkey, String key, String value) ;

    public long incr(String key) ;

    public long expire(String key, int second);

    public long ttl(String key) ;

}
