import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {
    private static JedisPool jedisPool = null;

    // 获取配置文件
    static {
        InputStream resource = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        // 关联文件
        try {
            pro.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        // 初始化
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        // 测试
        Jedis jedis = getJedis();
        // jedis.set("username", "byebye");
        String username = jedis.get("username");
        System.out.println(username);
        // jedis.del("username");
        jedis.close();
    }
}
