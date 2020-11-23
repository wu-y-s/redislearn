package com.wys.redislearn.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wys.redislearn.entity.NewTable;
import com.wys.redislearn.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.NewThreadAction;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
public class RedisCache implements Cache {

    private String id;

    public RedisCache(String id){
        this.id=id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override//放入缓存
    public void putObject(Object key, Object value) {
        //Jackson2JsonRedisSerializer j=new Jackson2JsonRedisSerializer<>(Object.class);
        //获取对象
        RedisTemplate redisTemplate=(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");

        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(j);
        //设置hashkey序列化
        //redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //redisTemplate.setHashValueSerializer(j);

        redisTemplate.opsForHash().put(id.toString(),key.toString(),value);

        //redisTemplate.opsForValue().set(key.toString(),value);
    }

    @Override//从缓存中获取
    public Object getObject(Object key) {
        //Jackson2JsonRedisSerializer j=new Jackson2JsonRedisSerializer<>(Object.class);

        RedisTemplate redisTemplate=(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");

        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        //redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        //redisTemplate.setValueSerializer(j);
        //redisTemplate.setHashValueSerializer(j);

        return  redisTemplate.opsForHash().get(id.toString(),key.toString());
    }

    @Override//删除缓存中数据
    public Object removeObject(Object key) {
        return null;
    }

    @Override//清空缓存
    public void clear() {
        RedisTemplate redisTemplate=(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.delete(id.toString());
    }

    @Override//缓存命中率
    public int getSize() {
        RedisTemplate redisTemplate=(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        //获取当前namespaces中缓存数据
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    @Override//读写锁  读写互斥，读读不互斥//synchronized
    public ReadWriteLock getReadWriteLock() {
        return null;
        //return new ReentrantReadWriteLock();
    }
}
