package cn.liuc.activitidemo.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2019/11/16 13:17
 */
@Configuration
public class DruidConfig {
    /**
     * 使用DruidDataSourceBuilder创建数据源
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

}
