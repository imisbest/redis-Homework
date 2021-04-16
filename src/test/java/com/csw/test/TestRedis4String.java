package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis4String {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test
    public void testset() {
        String aaa = jedis.set("aaa", "sss");
        System.out.println(aaa);
    }

    @Test
    public void testget() {
        String aaa = jedis.get("aaa");
        System.out.println(aaa);
    }

    @Test
    public void testmset() {
        String aaa = jedis.mset("a1", "a1", "a2", "a2", "a3", "a3");
        System.out.println(aaa);
    }

    @Test
    public void testmget() {
        List<String> aaa = jedis.mget("a1", "a2", "a3");
        aaa.forEach(a -> System.out.println(a));
    }

    @Test
    public void testgetset() {
        String aa = jedis.getSet("a1", "ss");
        System.out.println(aa);
    }

    @Test
    public void teststrlen() {
        Long aa = jedis.strlen("a1");
        System.out.println(aa);
    }

    @Test
    public void testappend() {
        Long aa = jedis.append("a1", "a1");
        System.out.println(aa);
    }

    @Test
    public void testgetrange() {
        String aa = jedis.getrange("a1", 0, 2);
        System.out.println(aa);
    }

    @Test
    public void testsetex() {
        String aa = jedis.setex("ssa", 100, "21");
        System.out.println(aa);
    }

    @Test
    public void testpsetex() {
        String aa = jedis.setex("ssa2", 100000, "22");
        System.out.println(aa);
    }

    @Test
    public void testsetnx() {
        Long aa = jedis.setnx("a8", "qq");
        System.out.println(aa);
    }

    @Test
    public void testmsetnx() {
        Long aa = jedis.msetnx("a8", "qq", "a9", "11", "a12", "55");
        System.out.println(aa);
    }

    @Test
    public void testdecr() {
        Long aa = jedis.decr("aaa");
        System.out.println(aa);
    }

    @Test
    public void testdecrby() {
        Long aa = jedis.decrBy("aaa", 2);
        System.out.println(aa);
    }

    @Test
    public void testIncr() {
        Long aa = jedis.incr("aaa");
        System.out.println(aa);
    }

    @Test
    public void testincrby() {
        Long aa = jedis.decrBy("aaa", 2);
        System.out.println(aa);
    }

    @Test
    public void testIncrbyfloat() {
        Double aa = jedis.incrByFloat("aaa", 2.46678978907);
        System.out.println(aa);
    }

    @After
    public void after() {
        jedis.close();
    }
}
