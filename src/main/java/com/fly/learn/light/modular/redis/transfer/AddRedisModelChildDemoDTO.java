package com.fly.learn.light.modular.redis.transfer;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:50
 * @Description: 添加redis子级
 * @Modified:
 */
@Data
public class AddRedisModelChildDemoDTO {

    private String id;

    private String name;

    private Integer parentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
