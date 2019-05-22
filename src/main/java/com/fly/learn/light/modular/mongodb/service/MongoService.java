package com.fly.learn.light.modular.mongodb.service;

import com.fly.learn.light.modular.mongodb.transfer.AddMongoModelParentDemoDTO;
import com.fly.learn.light.modular.mongodb.transfer.UpdateMongoParentDemoDTO;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/22 下午4:31
 * @Description: Mongo服务
 * @Modified:
 */
public interface MongoService {

    /**
     *@Author:Fly Created in 2019/5/22 下午4:34
     *@Description: 添加Mongo父级数据
     */
    Object addMongoModelParent(AddMongoModelParentDemoDTO addMongoModelParentDemoDTO);

    /**
     *@Author:Fly Created in 2019/5/22 下午5:00
     *@Description: 查询所有父级数据
     */
    Object findMongoModelParentAll();

    /**
     *@Author:Fly Created in 2019/5/22 下午4:35
     *@Description: 根据Id查询父级数据
     */
    Object findMongoModelParentById(Integer id);

    /**
     *@Author:Fly Created in 2019/5/22 下午4:37
     *@Description: 修改Mongo父级数据
     */
    Object updateMongoModelParentByName(UpdateMongoParentDemoDTO updateMongoParentDemoDTO);

    /**
     *@Author:Fly Created in 2019/5/22 下午4:38
     *@Description: 删除父级数据，根据id
     */
    Object removeMongoModelParentById(Integer id);
}
