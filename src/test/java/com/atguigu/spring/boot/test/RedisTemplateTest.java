package com.atguigu.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {

        // 1.获取Operation对象
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        // 2.设置值
        operations.set("dog", "wangwang");

        // 3.获取值
        String dog = operations.get("dog");
        System.out.println(dog);

    }

    @Test
    public void testRedisTemplate() {

        // 1.根据要操作的类型获取Operations对象
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();

        // 2.执行操作
        operations.set("cat", "mimi");
    }

    @Test
    public void testRedisTemplateGet() {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        Object cat = operations.get("cat");
        System.out.println(cat);
    }

}
