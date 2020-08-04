package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;


/**
 * @author zmj
 * @date 2020/8/4 15:20
 * @Description
 */
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
