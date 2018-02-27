package com.serve.message.service.Impl;

import com.serve.message.dto.OrderMasterDTO;
import com.serve.message.entity.UserInfo;
import com.serve.message.service.OrderMasterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*Created by Chandler
 *createDate:2018/2/26
 *createTime:21:32
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterServiceImplTest {
    @Autowired
    private OrderMasterService orderMasterService;

    private final String OPENID= "1311111";
    private final String ORDERMASTERID = "1519652348669426299";

    @Test
    public void create() {
        UserInfo userInfo =new UserInfo();
        OrderMasterDTO order = new OrderMasterDTO();
        order.setMessageId("1111111222255");
        order.setOpenId("1311111");
        order.setToOpenId("bbbbb");
        order.setTitle("代取快递");
        order.setContent("百世快递123456");
        order.setRemark("6点送到寝室");
        order.setName("Chandler");
        order.setOrderType(1);
        order.setAddress(userInfo.getAddress());
        order.setPhone(userInfo.getPhone());
        orderMasterService.create(order);
    }

    @Test
    public void findByOpenIdList() {

        PageRequest request = new PageRequest(0,5);
        Page<OrderMasterDTO>orderMasterDTOS = orderMasterService.findByOpenIdList(OPENID,request);
        Assert.assertNotEquals(0,orderMasterDTOS.getTotalElements());
    }

    @Test
    public void findByOrderId() {
        OrderMasterDTO orderMasterDTO = orderMasterService.findByOrderId(ORDERMASTERID);
        Assert.assertNotNull(orderMasterDTO);
    }
}