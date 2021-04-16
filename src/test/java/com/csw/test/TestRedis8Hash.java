package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis8Hash {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test
    public void testhset() {
        Long h1 = jedis.hset("h1", "33", "32");
        System.out.println(h1);
        Long h2 = jedis.hset("h1", "44", "44");
        System.out.println(h1);
    }

    @Test
    public void testhget() {
        String h1 = jedis.hget("h1", "33");
        System.out.println(h1);
    }

    @Test
    public void testhgetall() {
        Map<String, String> stringStringMap = jedis.hgetAll("33");
        Set<String> set = jedis.keys("*");
        for (String s : set) {
            System.out.println(s);
        }
    }

    @Test
    public void testhdel() {
        Long h1 = jedis.hdel("h1", "33");
        System.out.println(h1);
    }

    @Test
    public void testhexists() {
        Boolean h1 = jedis.hexists("h1", "33");
        System.out.println(h1);
    }

    @Test
    public void testhkeys() {
        Set<String> h1 = jedis.hkeys("h1");
        h1.forEach(h -> System.out.println(h));
    }

    @Test
    public void testhvals() {
        List<String> h1 = jedis.hvals("h1");
        h1.forEach(l -> System.out.println(l));
    }

    @Test
    public void testhmset() {
        HashMap<String, String> map = new HashMap<>();
        map.put("22", "33");
        map.put("44", "55");
        jedis.hmset("m2", map);
    }

    @Test
    public void testhmget() {
        List<String> aa = jedis.hmget("h1", "2", "33", "44", "55");
        aa.forEach(l -> System.out.println(l));
    }

    @Test
    public void testhsetnx() {
        Long h3 = jedis.setnx("h3", "88");
        System.out.println(h3);
    }

    @Test
    public void testhincrby() {
        Long h3 = jedis.hincrBy("h1", "33", 10);
        System.out.println(h3);
    }

    @Test
    public void testhincrbyfloat() {
        Double h3 = jedis.hincrByFloat("h1", "33", 10.568);
        System.out.println(h3);
    }

    @After
    public void after() {
        jedis.close();
    }
}
