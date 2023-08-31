package com.example.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void addToCache(String key, String value) {
        log.info("Object with key {} and value {} is added in redis",key,value);
        redisTemplate.opsForValue().set(key, value);
    }

    public String getFromCache(String key) {
        log.info("Retrieves a value with a key of {} from redis",key);
        return redisTemplate.opsForValue().get(key);
    }
}

