import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    public static void main(String args[]) {
        // 1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2. 操作

        // String 类型
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.setex("activeCode", 20, "123456");
        jedis.del("username");

        // hash 类型
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "11");
        jedis.hset("user", "gender", "male");

        Map<String, String> user =  jedis.hgetAll("user");
        Set<String> key = user.keySet();
        for(String s : key) {
            String value = user.get(s);
            System.out.println(s + " : " + value);
        }
        jedis.del("user");

        // list 类型
        jedis.lpush("myList", "a", "b", "c");
        jedis.rpush("myList", "a", "b", "c");
        List<String> list = jedis.lrange("myList", 0, -1);
        System.out.println(list);
        jedis.del("myList");

        // set 类型
        jedis.sadd("myset", "a", "b", "c");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.del("myset");

        // sortedset 类型
        jedis.zadd("mysort", 3, "a");
        jedis.zadd("mysort", 4, "b");
        jedis.zadd("mysort", 5, "c");
        Set<String> set = jedis.zrange("mysort", 0, -1);
        System.out.println(set);
        jedis.del("mysort");

        // 3. 关闭连接
        jedis.close();
    }
}
