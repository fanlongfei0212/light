package com.fly.learn.light.modular.mongodb.transfer;

import com.fly.learn.light.modular.redis.transfer.AddRedisModelChildDemoDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/22 下午4:29
 * @Description: 添加mongo父级数据
 * @Modified:
 */
@Data
public class AddMongoModelParentDemoDTO {

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    List<AddMongoModelChildDemoDTO> addMongoModelChildDemoDTOS;
}
