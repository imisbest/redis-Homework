package com.csw.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedis2Conn {

    @Test
    public void testConn() {

        //创建jedis客户端对象
        //参数1:主机ip 参数2:端口
        Jedis jedis = new Jedis("106.13.236.137", 7000);

        //操作redis 选择一个库 默认也是0号库

       // jedis.select(0);//选择零号库

        String n = jedis.get("n");
       System.out.println(n);


    }
}
