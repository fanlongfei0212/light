package com.fly.learn.light.modular.redis.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:47
 * @Description: 添加Redis父级DTO
 * @Modified:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRedisModelParentDemoDTO{

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    List<AddRedisModelChildDemoDTO> addRedisModelChildDemoDTOS;
}
