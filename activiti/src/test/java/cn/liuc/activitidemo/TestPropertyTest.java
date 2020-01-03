package cn.liuc.activitidemo;

import cn.liuc.activitidemo.vo.TestProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Date: 2020/1/3 22:54
 */
@SpringBootTest
public class TestPropertyTest {
    @Autowired
    TestProperty testProperty;

    @Test
    public void test() {
        System.out.println(testProperty.getTestKey());
        System.out.println(testProperty.getTestValue());
    }
}
