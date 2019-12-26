package cn.liuc.activitidemo.dao;

import cn.liuc.activitidemo.entity.ActHiActinstEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Date: 2019/12/26 22:04
 */
@SpringBootTest
public class ActHiActinstDaoTest {
    @Autowired
    ActHiActinstDao actHiActinstDao;

    @Test
    public void test() {
        ActHiActinstEntity actHiActinstEntity = actHiActinstDao.queryById("11");
        System.out.println(actHiActinstEntity.getTaskId());
    }


}
