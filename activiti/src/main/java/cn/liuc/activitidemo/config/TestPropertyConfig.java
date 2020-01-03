package cn.liuc.activitidemo.config;

import cn.liuc.activitidemo.vo.TestProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2020/1/3 22:39
 */
@Configuration
public class TestPropertyConfig {
    @Bean
    @ConfigurationProperties(prefix = "test.property")
    public TestProperty getTestProperty() {
        TestProperty testProperty = new TestProperty();
        testProperty.setTestKey("changeKey");
        testProperty.setTestValue("changeValue");
        return testProperty;
    }
}


