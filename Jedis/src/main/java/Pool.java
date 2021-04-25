import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Pool {
    public static void main(String[] args) {
        /*
        使用：
        1、创建 JedisPool 连接池对象
        2、调用方法 getResource() 方法获取 Jedis 连接
         */

        // 设置配置（可以不需要）
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        // JedisPool jedisPool = new JedisPool();   可以不指定参数，使用默认配置
        // 获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("username", "hello");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.del("username");

        // 归还到连接池中
        jedis.close();
    }
}
