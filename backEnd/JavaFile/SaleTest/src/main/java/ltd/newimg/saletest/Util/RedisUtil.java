package ltd.newimg.saletest.Util;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-27 15:09
 */
@Component
public class RedisUtil {

    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    public void setValue(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    public int incr(Object key) {
        return Math.toIntExact(redisTemplate.opsForValue().increment(key));
    }
}
