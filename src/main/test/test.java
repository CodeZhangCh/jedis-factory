import com.cache.factory.redis.JedisUtil;
import redis.clients.jedis.Jedis;

/**
 * @Author: zhangch
 * @Description:
 * @Date: Created in 16:14 2017/1/7
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getClient();
        jedis.set("a","1");
        System.out.print(jedis.get("a"));
    }
}
