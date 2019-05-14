package com.fly.learn.light.modular.redis.service;

import com.fly.learn.light.modular.redis.transfer.AddRedisModelChildDemoDTO;
import com.fly.learn.light.modular.redis.transfer.AddRedisModelParentDemoDTO;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/12 下午11:58
 * @Description: redis接口
 * @Modified:
 */
public interface RedisService {

    /**
     *@Author:Fly Created in 2019/5/12 下午11:59
     *@Description: 添加父级
     */
    Object addRedisModelParent(AddRedisModelParentDemoDTO addRedisModelParentDemoDTO);

    /**
     *@Author:Fly Created in 2019/5/13 上午12:00
     *@Description: 根据id查询父级
     */
    Object findRedisModelParentById(Integer id);

    /**
     *@Author:Fly Created in 2019/5/14 下午3:10
     *@Description: 根据id删除父级
     */
    Object removeRedisModelParentById(Integer id);
}
