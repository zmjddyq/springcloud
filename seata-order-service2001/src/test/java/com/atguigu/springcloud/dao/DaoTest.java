package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zmj
 * @date 2020/8/4 10:56
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void test(){
        int i = orderDao.updateStatus(new Long(1), 1);
        System.out.println(i);
    }
}
