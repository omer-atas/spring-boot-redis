package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis-controller")
public class RedisController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/cache/{key}")
    public ResponseEntity<String > getFromCache(@PathVariable String key) {
        return ResponseEntity.ok(this.redisService.getFromCache(key));
    }

    @PostMapping("/addToCache")
    public ResponseEntity<Void> addToCache(@RequestParam String key,@RequestParam String value) {
        this.redisService.addToCache(key, value);
        return ResponseEntity.ok().build();
    }
}