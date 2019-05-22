# light

## 简介

**本项目主要进行对常用工具的集成学习，准备依次进行对 Redis、mongoDB、Elasticsearch进行集成**

* StringBoot 2.0 集成项目
* Maven 3.3.9
* JDK 1.8
* StringBoot 2.1.4.RELEASE
* Redis 4.0.7

| 项目名称 | 项目版本 | 修订时间 | 修订人 | 修订原因 |
|:------:| :------: | :------: | :------: | :------: |
| light | V 1.0.0 | 2019年05月13日17:13:59 | 范龙飞 | 初始化项目概要信息 |
| light | V 1.0.0 | 2019年05月14日15:48:05 | 范龙飞 | 资料记录 |
| light | V 1.0.0 | 2019年05月22日17:52:59 | 范龙飞 | MongoTemplate 基本使用 |

### 集成Redis

* 参考资料
    
    * [https://www.cnblogs.com/ityouknow/p/5748830.html](https://www.cnblogs.com/ityouknow/p/5748830.html)
    * [https://www.cnblogs.com/wangzhuxing/p/10198347.html](https://www.cnblogs.com/wangzhuxing/p/10198347.html)

* 使用 RedisTemplate 中 ValueOperations 的基本功能

    **使用 ValueOperations 作为对Redis的字符串操作;如果 value 作为一个对象的的话，通常的做法是将 value 进行序列化，然后存储至Redis中**
    
    * 配置RedisTemplate的key序列化类型以及value的序列化类型
    
    * value的序列化使用Jackson进行序列化
    
    * 使用Jackson作为value的序列化时要注意LocalDateTime的序列化问题，需要进行手动配置
    
    * 具体配置代码参照 src/main/java/com.fly.learn.light.conf.redis/RedisConf 
    
    * 需要引入 commons-pool2 包
        ```xml
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
        </dependency>
        ```
### 集成MongoDB

* 参考资料
    
    * [http://www.ityouknow.com/springboot/2017/05/08/spring-boot-mongodb.html](http://www.ityouknow.com/springboot/2017/05/08/spring-boot-mongodb.html)

* MongoDB启动命令

    **指定数据存放位置、日志位置、日志方式**

    ```zsh
    mongod --dbpath ../WorkSpace/SoftwareData/MongoDB/data --logpath ../WorkSpace/SoftwareData/MongoDB/log/mongod.log --logappend --fork
    ```
    
* 使用 MongoTemplate
    
    * 需要引入 commons-pool2 包
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
        ```
    