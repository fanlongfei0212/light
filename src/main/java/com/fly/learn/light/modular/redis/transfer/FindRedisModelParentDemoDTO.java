package com.fly.learn.light.modular.redis.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:52
 * @Description: 查询所有父级
 * @Modified:
 */
@Data
public class FindRedisModelParentDemoDTO {

    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private List<FindRedisModelChildDemoDTO> childDemoDTOS;
}
