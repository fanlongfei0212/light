package com.fly.learn.light.modular.mongodb.service.impl;

import com.fly.learn.light.common.UUIDUtils;
import com.fly.learn.light.modular.mongodb.service.MongoService;
import com.fly.learn.light.modular.mongodb.transfer.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/22 下午4:31
 * @Description: Mongo实现
 * @Modified:
 */
@Service
public class MongoServiceImpl implements MongoService{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Object addMongoModelParent(AddMongoModelParentDemoDTO addMongoModelParentDemoDTO) {

        addMongoModelParentDemoDTO.setCreateTime(LocalDateTime.now());
        addMongoModelParentDemoDTO.setUpdateTime(LocalDateTime.now());
        addMongoModelParentDemoDTO.setAddMongoModelChildDemoDTOS(
                this.settingAddMongoModelChildDemoDTO(addMongoModelParentDemoDTO.getId(), addMongoModelParentDemoDTO.getAddMongoModelChildDemoDTOS()));

        mongoTemplate.save(addMongoModelParentDemoDTO);

        return "ok";
    }

    @Override
    public Object findMongoModelParentAll() {

        return this.settingFindMongoModelParentDemoDTO(mongoTemplate.findAll(AddMongoModelParentDemoDTO.class));
    }

    @Override
    public Object findMongoModelParentById(Integer id) {

        Query query = new Query(Criteria.where("id").is(id));

        AddMongoModelParentDemoDTO addMongoModelParentDemoDTO = mongoTemplate.findOne(query, AddMongoModelParentDemoDTO.class);

        if (Objects.nonNull(addMongoModelParentDemoDTO)){

            FindMongoModelParentDemoDTO result = new FindMongoModelParentDemoDTO();

            result.setId(addMongoModelParentDemoDTO.getId());
            result.setName(addMongoModelParentDemoDTO.getName());
            result.setCreateTime(addMongoModelParentDemoDTO.getCreateTime());
            result.setUpdateTime(addMongoModelParentDemoDTO.getUpdateTime());

            result.setChildDemoDTOS(
                    this.settingFindAddMongoModelChildDemoDTO(addMongoModelParentDemoDTO.getAddMongoModelChildDemoDTOS()));

            return result;
        }

        return null;
    }

    @Override
    public Object updateMongoModelParentByName(UpdateMongoParentDemoDTO updateMongoParentDemoDTO) {

        Query query = new Query(Criteria.where("name").is("父级1"));

        Update update = new Update().set("name", updateMongoParentDemoDTO.getName()).set("updateTime", LocalDateTime.now());

        UpdateResult result = mongoTemplate.updateMulti(query, update, AddMongoModelParentDemoDTO.class);

        if (Objects.nonNull(result)){

            return "ok";
        }

        return "error";
    }

    @Override
    public Object removeMongoModelParentById(Integer id) {

        Query query = new Query(Criteria.where("id").is(id));

        DeleteResult result = mongoTemplate.remove(query, AddMongoModelParentDemoDTO.class);

        return "ok";
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午4:53
     *@Description: 重组子级数据
     */
    private List<AddMongoModelChildDemoDTO> settingAddMongoModelChildDemoDTO(Integer parentId, List<AddMongoModelChildDemoDTO> addMongoModelChildDemoDTOS){

        if (Objects.nonNull(addMongoModelChildDemoDTOS)){

            return addMongoModelChildDemoDTOS.stream().map(obj -> {

                obj.setId(UUIDUtils.getStrNumberUUID());
                obj.setCreateTime(LocalDateTime.now());
                obj.setUpdateTime(LocalDateTime.now());
                obj.setParentId(parentId);

                return obj;
            }).collect(Collectors.toList());
        }

        return null;
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:08
     *@Description: 重组子级数据
     */
    private List<FindMongoModelChildDemoDTO> settingFindAddMongoModelChildDemoDTO(List<AddMongoModelChildDemoDTO> addMongoModelChildDemoDTOS){

        if (Objects.nonNull(addMongoModelChildDemoDTOS)){

            return addMongoModelChildDemoDTOS.stream().map(obj -> {

                FindMongoModelChildDemoDTO result = new FindMongoModelChildDemoDTO();

                result.setId(obj.getId());
                result.setCreateTime(obj.getCreateTime());
                result.setUpdateTime(obj.getUpdateTime());
                result.setParentId(obj.getParentId());
                result.setName(obj.getName());

                return result;
            }).collect(Collectors.toList());
        }

        return null;
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:02
     *@Description: 重组父级数据
     */
    private List<FindMongoModelParentDemoDTO> settingFindMongoModelParentDemoDTO(List<AddMongoModelParentDemoDTO> addMongoModelParentDemoDTOS){

        if (Objects.nonNull(addMongoModelParentDemoDTOS)){

            return addMongoModelParentDemoDTOS.stream().map(obj -> {

                FindMongoModelParentDemoDTO result = new FindMongoModelParentDemoDTO();

                result.setId(obj.getId());
                result.setCreateTime(obj.getCreateTime());
                result.setUpdateTime(obj.getUpdateTime());
                result.setName(obj.getName());
                result.setChildDemoDTOS(this.settingFindAddMongoModelChildDemoDTO(obj.getAddMongoModelChildDemoDTOS()));

                return result;
            }).collect(Collectors.toList());
        }

        return null;
    }
}
