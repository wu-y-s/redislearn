package com.wys.redislearn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//会话管理
@Configuration
@EnableRedisHttpSession
public class RedisSessionManager {
}
