package com.myredis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moviemapper.MovieMapper;
import com.moviepojo.EUMovieGridResult;
import com.moviepojo.Movie;
import com.moviepojo.MovieExample;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by hestersmile on 2017/1/2.
 */
    public class MyBatisCacheSecondTest
    {
        private static final Logger logger = LoggerFactory.getLogger(MyBatisCacheSecondTest.class);

        @Autowired
        private MovieMapper movieMapper;

        /*
         * 二级缓存测试
         */
        @Test
        public void testCache2() {
            MovieExample example = new MovieExample();
            PageHelper.startPage(1, 7);
            List<Movie> list = movieMapper.selectByExample(example);
            EUMovieGridResult result = new EUMovieGridResult();
            result.setRows(list);
            PageInfo<Movie> pageInfo = new PageInfo<>(list);
            logger.info(pageInfo.getList().get(1).getMovieTitle());

        }
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
            pool.close();
        }

        @Test
        public void testSpringJedisSingle() {
            InitRedisClient initRedisClient = new InitRedisClient();
            Jedis jedis = initRedisClient.getJedis();

            jedis.set("key1", "jedis test");
            String string = jedis.get("key1");
            System.out.println(string);
            jedis.close();
        }


    }
