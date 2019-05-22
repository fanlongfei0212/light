package com.fly.learn.light.modular.mongodb.controller;

import com.fly.learn.light.modular.mongodb.service.MongoService;
import com.fly.learn.light.modular.mongodb.transfer.AddMongoModelParentDemoDTO;
import com.fly.learn.light.modular.mongodb.transfer.UpdateMongoParentDemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/22 下午4:44
 * @Description: MongoController
 * @Modified:
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    /**
     *@Author:Fly Created in 2019/5/22 下午4:46
     *@Description: 添加Mongo父级数据
     */
    @PostMapping(value = "/add/parent")
    public Object addMongoModelParent(@RequestBody AddMongoModelParentDemoDTO addMongoModelParentDemoDTO){

        return mongoService.addMongoModelParent(addMongoModelParentDemoDTO);
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:19
     *@Description: 查询所有父级数据
     */
    @GetMapping(value = "/find/parent/all")
    public Object findMongoModelParentAll(){

        return mongoService.findMongoModelParentAll();
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:20
     *@Description: 根据id查询父级数据
     */
    @GetMapping(value = "/find/parent/by/{id}")
    public Object findMongoModelParentById(@PathVariable("id") Integer id){

        return mongoService.findMongoModelParentById(id);
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:38
     *@Description: 修改父级数据，根据id
     */
    @PostMapping(value = "/update/parent")
    public Object updateMongoModelParentByName(@RequestBody UpdateMongoParentDemoDTO updateMongoParentDemoDTO){

        return mongoService.updateMongoModelParentByName(updateMongoParentDemoDTO);
    }

    /**
     *@Author:Fly Created in 2019/5/22 下午5:40
     *@Description: 删除父级数据，根据id
     */
    @GetMapping(value = "/remove/parent/by/{id}")
    public Object removeMongoModelParentById(@PathVariable ("id") Integer id){

        return mongoService.removeMongoModelParentById(id);
    }
}
