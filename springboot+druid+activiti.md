# Springboot+druid+activiti

## 插件安装

使用 IDEA 进行开发，需要安装 `actiBPM` 插件。

如果涉及到中文乱码问题，需要修改 IDEA 安装目录下的文件，可以参考 <https://www.cnblogs.com/tianguodk/p/9414363.html>

## 创建项目

使用 IDEA 新建 Springboot 项目。

因为要使用 druid 做数据源，所以需要引入 druid starter 依赖。另外，使用的数据库是 mysql，还需要引入连接mysql 的驱动。

```
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.0</version>
        </dependency>
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
```

创建 DruidConfig 配置类，主要是 DataSource。

```java
@Configuration
public class DruidConfig {
    
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

}
```

引入 activiti 依赖，本项目使用的 activiti 版本为 6.0.0。

```
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-engine</artifactId>
            <version>6.0.0</version>
        </dependency>
```

创建 ActivitiConfig 配置类，使用 Druid 的 DataSource。

```java
@Configuration
public class ActivitiConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration() {
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }
    @Bean
    public ProcessEngine processEngine() {
        return processEngineConfiguration().buildProcessEngine();
    }
    @Bean
    public RepositoryService repositoryService() {
        return processEngine().getRepositoryService();
    }
    @Bean
    public RuntimeService runtimeService() {
        return processEngine().getRuntimeService();
    }
    @Bean
    public TaskService taskService() {
        return processEngine().getTaskService();
    }
}
```

## 本地测试

在 application.properties 文件中配置数据库信息，注意将下面的数据库名称、用户和密码修改为自己的。

```properties
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/yourDatabase?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=yourName
spring.datasource.password=yourPassword
```

创建测试用例，并执行。

```java
@SpringBootTest
class ActivitiDemoTests {

    @Autowired
    StandaloneProcessEngineConfiguration processEngineConfiguration;

    @Test
    public void test_createDatabase() {
        ProcessEngine pe = processEngineConfiguration.buildProcessEngine();
        pe.close();
    }

}
```

如果执行之后，数据库中新创建了 `act_` 前缀的二十多张表，则证明项目配置成功。后续就可以进行 Activiti 的相关开发了。