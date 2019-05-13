package com.fly.learn.light.modular.redis.controller;

import com.fly.learn.light.modular.redis.service.RedisService;
import com.fly.learn.light.modular.redis.transfer.AddRedisModelChildDemoDTO;
import com.fly.learn.light.modular.redis.transfer.AddRedisModelParentDemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:44
 * @Description:
 * @Modified:
 */
@RequestMapping(value = "/redis")
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     *@Author:Fly Created in 2019/5/12 下午11:49
     *@Description: 添加父级
     */
    @PostMapping(value = "/add/parent")
    public Object addRedisModelParent(@RequestBody AddRedisModelParentDemoDTO addRedisModelParentDemoDTO){

        return redisService.addRedisModelParent(addRedisModelParentDemoDTO);
    }

    /**
     *@Author:Fly Created in 2019/5/12 下午11:56
     *@Description: 根据id查询父级
     */
    @GetMapping(value = "/find/parent/by/{id}")
    public Object findRedisModelParentById(@PathVariable("id") Integer id){

        return redisService.findRedisModelParentById(id);
    }
}
