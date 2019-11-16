package cn.liuc.activitidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ActivitiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiDemoApplication.class, args);
    }

}
