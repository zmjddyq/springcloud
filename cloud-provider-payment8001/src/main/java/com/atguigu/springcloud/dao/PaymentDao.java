package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author zmj
 * @date 2020/7/28 20:55
 * @Description
 */
@Mapper
public interface PaymentDao {
    /**
     * 创建订单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 通过id获取订单
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
