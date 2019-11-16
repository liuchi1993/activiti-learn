# Springboot+druid+activiti

- 新建 Springboot 项目
- 引入 druid starter 依赖

```
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.0</version>
        </dependency>
```

- 创建 DruidConfig 配置类，主要是 DataSource 
- 引入 activiti 依赖
- 创建 ActivitiConfig 配置类，使用 Druid 的 DataSource