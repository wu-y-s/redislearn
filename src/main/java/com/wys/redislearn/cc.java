package com.wys.redislearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class cc {



    public static void main(String args[]){

        Jedis j=new Jedis("47.99.119.199",6379);//连接
        j.select(0);//选库

        Set<String> keys=j.keys("*");
        String n=j.get("");


        String z=j.setex("",60,"");

        Long x=j.del("","");

        j.expire("",60);//存活时间
        j.bgsave();//快照dump.rdb,保证在快照时不会阻塞主服务，fork优化，如无插入快照分更多内存，反之保证redis性能
        j.save();//快照，执行时不能set，阻塞客户端


    }
}
