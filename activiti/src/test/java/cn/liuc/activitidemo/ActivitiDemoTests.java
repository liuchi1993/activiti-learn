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
        // 构建流程引擎对象
        ProcessEngine pe = processEngineConfiguration.buildProcessEngine(); // 调用访方法才会创建数据表
        // 调用close方法时，才会删除
        pe.close();
    }

}
