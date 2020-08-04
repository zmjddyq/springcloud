package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Storage)实体类
 *
 * @author makejava
 * @since 2020-08-04 15:15:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage{
    
    private Long id;
    /**
    * 产品id
    */
    private Long productId;
    /**
    * 库存
    */
    private Integer total;
    /**
    * 已用库存
    */
    private Integer used;
    /**
    * 剩余库存
    */
    private Integer residue;

}