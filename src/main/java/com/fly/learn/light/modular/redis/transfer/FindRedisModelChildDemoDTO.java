package com.fly.learn.light.modular.redis.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:53
 * @Description: 根据父级id查询子级
 * @Modified:
 */
@Data
public class FindRedisModelChildDemoDTO {

    private String id;

    private String name;

    private Integer parentId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
