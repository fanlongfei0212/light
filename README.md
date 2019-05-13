# light

**StringBoot 2.0 集成项目**
**Maven 3.3.9**
**JDK 1.8**
**StringBoot 2.1.4.RELEASE**
**Redis 4.0.7**

| 项目名称 | 项目版本 | 修订时间 | 修订人 | 修订原因 |
|:------:| :------: | :------: | :------: | :------: |
| light | V 1.0.0 | 2019年05月13日17:13:59 | 范龙飞 | 初始化项目概要信息 |

## 集成Redis

* 使用 RedisTemplate 的基本功能
    
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