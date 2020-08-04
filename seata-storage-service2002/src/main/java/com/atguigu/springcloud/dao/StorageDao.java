package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-04 15:17:37
 */
@Mapper
public interface StorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Storage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Storage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tStorage 实例对象
     * @return 对象列表
     */
    List<Storage> queryAll(Storage tStorage);

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int insert(Storage tStorage);

    /**
     * 修改数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int update(Storage tStorage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}