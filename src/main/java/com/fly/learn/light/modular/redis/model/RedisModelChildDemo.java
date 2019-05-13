package com.fly.learn.light.modular.redis.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:38
 * @Description: 测试Redis子级类实体
 * @Modified:
 */
@Data
public class RedisModelChildDemo {

    private Integer id;

    private String name;

    private Integer parentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
