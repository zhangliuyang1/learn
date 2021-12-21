package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RedisUtil {

//    private static String path = "/Users/liuyangzhang/Documents/58/project/learn/src/main/resources/redis.properties";
    private static String path = "redis.properties";

    private static Properties properties = new Properties();

    private static JedisPool jedisPool = null;

    static {
        try {
            properties.load(new FileInputStream(path));
            JedisPoolConfig config = new JedisPoolConfig();
            System.out.println("======properties.getProperty(\"address\") " + properties.getProperty("address"));
            System.out.println("======properties.getProperty(\"port\") " + properties.getProperty("port"));
            config.setMaxTotal(Integer.parseInt(properties.getProperty("max_active")));
            config.setMaxIdle(Integer.parseInt(properties.getProperty("max_idle")));
            config.setMinIdle(Integer.parseInt(properties.getProperty("min_idle")));
            config.setMaxWaitMillis(Integer.parseInt(properties.getProperty("max_wait")));
            config.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("test_on_borrow")));
            jedisPool = new JedisPool(config, properties.getProperty("address"), Integer.parseInt(properties.getProperty("port")), Integer.parseInt(properties.getProperty("timeout")), properties.getProperty("auth"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


    public static void main(String[] args) {
        Jedis jedis = getJedis();
        String key = "20211220";
        long offset = 10;

        Boolean setbit = jedis.setbit(key, offset, true);

        Boolean getbit = jedis.getbit(key, offset);

        Boolean setbit1 = jedis.setbit(key, 4, true);

        Boolean setbit2 = jedis.setbit(key, 20, true);

        jedis.setbit(key, 1000000000, true);

        long start = System.currentTimeMillis();
        Long bitcount = jedis.bitcount(key);
        System.out.println("bitcount=" + bitcount + ", cost:" + (System.currentTimeMillis() - start));

        Boolean getbit1 = jedis.getbit(key, 1000000000);
        System.out.println("1亿=" + getbit1);
        Long bitcount1 = jedis.bitcount(key, 0, 0);
        Long bitcount2 = jedis.bitcount(key, 0, 1);
        Long bitcount3 = jedis.bitcount(key, 0, 2);

        System.out.println("====");

    }


}
