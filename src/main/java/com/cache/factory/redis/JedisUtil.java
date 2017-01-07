package com.cache.factory.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * @Author: zhangch
 * @Description: 单例
 * @Date: Created in 16:25 2017/1/7
 * @Modified By:
 */
public enum JedisUtil {

    instance;
    //读取master name配置信息
    private static String masterName = "master";
    //读取slave地址配置信息
    private static String slaves = ("127.0.0.1:26379,127.0.0.1:26380");
    private static JedisSentinelPool jedisPool = null;

    public static Jedis getClient() {
        if(jedisPool == null) {
            jedisPool = JedisSentinelPool.getPool(masterName,slaves);
        }
        return jedisPool.getResource();
    }

    //根据新参数reload连接池
    public static void reload(String masterName,String slaves) {
        if(jedisPool != null) {
            jedisPool.destroy();
            jedisPool = null;
        }
        jedisPool = JedisSentinelPool.getPool(masterName,slaves);
    }
}
