package cn.liuc.activitidemo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
