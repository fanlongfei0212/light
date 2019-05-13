package com.fly.learn.light.modular.redis.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:38
 * @Description: 测试Redis父级类实体
 * @Modified:
 */
@Data
public class RedisModelParentDemo {

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
