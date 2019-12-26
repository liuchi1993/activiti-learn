package cn.liuc.activitidemo.dao;

import java.util.List;

import cn.liuc.activitidemo.entity.ActHiActinstEntity;
import org.apache.ibatis.annotations.Param;

/**
 * (ActHiActinst)表数据库访问层
 * @since 2019-12-26 21:36:45
 */
public interface ActHiActinstDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ActHiActinstEntity queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ActHiActinstEntity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param actHiActinstEntity 实例对象
     * @return 对象列表
     */
    List<ActHiActinstEntity> queryAll(ActHiActinstEntity actHiActinstEntity);

    /**
     * 新增数据
     *
     * @param actHiActinstEntity 实例对象
     * @return 影响行数
     */
    int insert(ActHiActinstEntity actHiActinstEntity);

    /**
     * 修改数据
     *
     * @param actHiActinstEntity 实例对象
     * @return 影响行数
     */
    int update(ActHiActinstEntity actHiActinstEntity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}