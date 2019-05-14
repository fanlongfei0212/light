package com.fly.learn.light.modular.redis.service.impl;

import com.fly.learn.light.common.UUIDUtils;
import com.fly.learn.light.modular.redis.service.RedisService;
import com.fly.learn.light.modular.redis.transfer.AddRedisModelChildDemoDTO;
import com.fly.learn.light.modular.redis.transfer.AddRedisModelParentDemoDTO;
import com.fly.learn.light.modular.redis.transfer.FindRedisModelChildDemoDTO;
import com.fly.learn.light.modular.redis.transfer.FindRedisModelParentDemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/13 上午12:01
 * @Description: Redis实现
 * @Modified:
 */
@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Object addRedisModelParent(AddRedisModelParentDemoDTO addRedisModelParentDemoDTO) {

        addRedisModelParentDemoDTO.setCreateTime(LocalDateTime.now());
        addRedisModelParentDemoDTO.setUpdateTime(LocalDateTime.now());
        addRedisModelParentDemoDTO.setAddRedisModelChildDemoDTOS(
                this.settingAddRedisModelChildDemoDTO(
                        addRedisModelParentDemoDTO.getId(),
                        addRedisModelParentDemoDTO.getAddRedisModelChildDemoDTOS()));

        ValueOperations<String, AddRedisModelParentDemoDTO> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("redisModelParent" + addRedisModelParentDemoDTO.getId(), addRedisModelParentDemoDTO);

        return "ok";
    }

    /**
     *@Author:Fly Created in 2019/5/13 下午4:40
     *@Description: 重组子级数据
     */
    private List<AddRedisModelChildDemoDTO> settingAddRedisModelChildDemoDTO(Integer parentId, List <AddRedisModelChildDemoDTO> addRedisModelChildDemoDTOS){

        if (Objects.nonNull(addRedisModelChildDemoDTOS)){

            return addRedisModelChildDemoDTOS.stream().map(obj -> {

                obj.setCreateTime(LocalDateTime.now());
                obj.setUpdateTime(LocalDateTime.now());
                obj.setId(UUIDUtils.getStrNumberUUID());
                obj.setParentId(parentId);

                return obj;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Object findRedisModelParentById(Integer id) {

        ValueOperations<String, AddRedisModelParentDemoDTO> valueOperations = redisTemplate.opsForValue();

        AddRedisModelParentDemoDTO addRedisModelParentDemoDTO = valueOperations.get("redisModelParent" + id);

        if (Objects.nonNull(addRedisModelParentDemoDTO)){

            FindRedisModelParentDemoDTO result = new FindRedisModelParentDemoDTO();

            result.setId(addRedisModelParentDemoDTO.getId());
            result.setName(addRedisModelParentDemoDTO.getName());
            result.setCreateTime(addRedisModelParentDemoDTO.getCreateTime());
            result.setUpdateTime(addRedisModelParentDemoDTO.getUpdateTime());
            result.setChildDemoDTOS(this.settingFindRedisModelChildDemoDTO(addRedisModelParentDemoDTO.getAddRedisModelChildDemoDTOS()));

            return result;
        }

        return null;
    }

    @Override
    public Object removeRedisModelParentById(Integer id) {

        String removeKey = "redisModelParent" + id;

        return redisTemplate.hasKey(removeKey) ? (redisTemplate.delete(removeKey) ? "ok" : "error") : "key不存在";
    }

    /**
     *@Author:Fly Created in 2019/5/13 下午4:43
     *@Description: 重组子级数据
     */
    private List<FindRedisModelChildDemoDTO> settingFindRedisModelChildDemoDTO(List<AddRedisModelChildDemoDTO> addRedisModelChildDemoDTOS){

        if (Objects.nonNull(addRedisModelChildDemoDTOS)){

            return addRedisModelChildDemoDTOS.stream().map(obj -> {

                FindRedisModelChildDemoDTO result = new FindRedisModelChildDemoDTO();

                result.setCreateTime(obj.getCreateTime());
                result.setUpdateTime(obj.getUpdateTime());
                result.setId(obj.getId());
                result.setName(obj.getName());
                result.setParentId(obj.getParentId());

                return result;
            }).collect(Collectors.toList());
        }

        return null;
    }
}
