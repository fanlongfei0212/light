package com.fly.learn.light.modular.mongodb.transfer;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/22 下午4:28
 * @Description: 添加mongo子级数据
 * @Modified:
 */
@Data
public class AddMongoModelChildDemoDTO {

    private String id;

    private String name;

    private Integer parentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
