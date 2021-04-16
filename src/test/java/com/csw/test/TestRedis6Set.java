package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis6Set {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test
    public void testsadd() {
        Long ss = jedis.sadd("s1", "2", "3");
        System.out.println(ss);
    }

    @Test
    public void testsmembers() {
        Set<String> ss = jedis.smembers("s1");
        ss.forEach(s -> System.out.println(s));
    }

    @Test
    public void testscard() {
        Long ss = jedis.scard("s1");
        System.out.println(ss);
    }

    @Test
    public void testspop() {
        String ss = jedis.spop("s1");
        System.out.println(ss);
    }

    @Test
    public void testsmove() {
        Long ss = jedis.smove("s1", "s2", "44");
        System.out.println(ss);
    }

    @Test
    public void testsrem() {
        Long ss = jedis.srem("s2", "44");
        System.out.println(ss);
    }

    @Test
    public void testsismember() {
        Boolean ss = jedis.sismember("s2", "44");
        System.out.println(ss);
    }

    @Test
    public void testsrandmember() {
        String ss = jedis.srandmember("s1");
        System.out.println(ss);
    }

    @Test
    public void testsdiff() {
        Set<String> ss = jedis.sdiff("s1", "s2");
        ss.forEach(s -> System.out.println(s));
    }

    @Test
    public void testsinter() {
        Set<String> ss = jedis.sinter("s1", "s2");
        ss.forEach(s -> System.out.println(s));
    }

    @Test
    public void testsunion() {
        Set<String> ss = jedis.sunion("s1", "s2");
        ss.forEach(s -> System.out.println(s));
    }

    @After
    public void after() {
        jedis.close();
    }
}
