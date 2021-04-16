package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis3Keys {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test/*删除*/
    public void test1() {
        Long del = jedis.del("c", "c");
        System.out.println(del);
    }

    @Test/*判断某个key的类型*/
    public void test2() {
        String type = jedis.type("hash1");
        System.out.println(type);
    }

    @Test/*查询所有的key*/
    public void test3() {
        Set<String> keys = jedis.keys("*");
        keys.forEach(key -> System.out.println(key));
    }

    @Test/*返回随机的key*/
    public void test4() {
        String key = jedis.randomKey();
        System.out.println(key);
    }

    @Test/*返回key的失效时间*/
    public void test5() {
        Long ttl = jedis.ttl("zset1");
        System.out.println(ttl);
    }

    @Test/*移动某个key到指定库中*/
    public void test6() {
        jedis.move("a", 1);
    }

    @After
    public void after() {
        jedis.close();
    }
}
