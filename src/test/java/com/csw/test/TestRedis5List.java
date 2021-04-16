package com.csw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis5List {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("106.13.236.137", 7000);
    }

    @Test
    public void testlpush() {

        Long list = jedis.lpush("l1", "22");
        System.out.println(list);
    }

    @Test
    public void testlpushx() {
        Long list = jedis.lpushx("l1", "22", "33", "44");
        System.out.println(list);
    }

    @Test
    public void testrpush() {
        Long list = jedis.rpush("l1", "77");
        System.out.println(list);
    }

    @Test
    public void testrpushx() {
        Long list = jedis.rpushx("l1", "77", "88", "99");
        System.out.println(list);
    }

    @Test
    public void testlpop() {
        String list = jedis.lpop("l1");
        System.out.println(list);
    }

    @Test
    public void testrpop() {
        String list = jedis.rpop("l1");
        System.out.println(list);
    }

    @Test
    public void testlrange() {
        List<String> list = jedis.lrange("l1", 0, 1);
        list.forEach(l -> System.out.println(l));
    }

    @Test
    public void testllen() {
        Long list = jedis.llen("l1");
        System.out.println(list);
    }

    @Test
    public void testlset() {
        String list = jedis.lset("l1", 1, "2222");
        System.out.println(list);
    }

    @Test
    public void testlindex() {
        String list = jedis.lindex("l1", 1);
        System.out.println(list);
    }

    @Test
    public void testlrem() {
        Long list = jedis.lrem("l1", 1, "2222");
        System.out.println(list);
    }

    @Test
    public void testltrim() {
        String list = jedis.ltrim("l1", 1, 2);
        System.out.println(list);
    }

    @Test
    public void testlinsert() {
        Long list = jedis.linsert("l1", BinaryClient.LIST_POSITION.AFTER, "22", "33");
        System.out.println(list);
    }

    @After
    public void after() {
        jedis.close();
    }
}
