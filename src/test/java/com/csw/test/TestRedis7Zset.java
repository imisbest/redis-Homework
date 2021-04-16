package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis7Zset {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test
    public void testzadd() {
        Long zz = jedis.zadd("z1", 10, "aa");
        System.out.println(zz);
    }

    @Test
    public void testzcard() {
        Long zz = jedis.zcard("z1");
        System.out.println(zz);
    }

    @Test
    public void testzrange() {
        Set<String> zz = jedis.zrange("z1", 0, 1);
        zz.forEach(z -> System.out.println(z));
    }

    @Test
    public void testzrevrange() {
        Set<String> zz = jedis.zrevrange("z1", 0, 1);
        zz.forEach(z -> System.out.println(z));
    }

    @Test
    public void testzrangebyscore() {
        Set<String> zz = jedis.zrangeByScore("z1", 0, 99);
        zz.forEach(z -> System.out.println(z));
    }

    @Test
    public void testzrank() {
        Long zz = jedis.zrank("z1", "ww");
        System.out.println(zz);
    }

    @Test
    public void testzrevrank() {
        Long zz = jedis.zrevrank("z1", "ww");
        System.out.println(zz);
    }

    @Test
    public void testzscore() {
        Double zz = jedis.zscore("z1", "ww");
        System.out.println(zz);
    }

    @Test
    public void testzrem() {
        Long zz = jedis.zrem("z1", "ww");
        System.out.println(zz);
    }

    @Test
    public void testzincrby() {
        Double zz = jedis.zincrby("z1", 10, "ww");
        System.out.println(zz);
    }

    @After
    public void after() {
        jedis.close();
    }
}
