package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2020-08-04 15:37:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 总额度
    */
    private Double total;
    /**
    * 已用额度
    */
    private Double used;
    /**
    * 剩余可用额度
    */
    private Double residue;

}