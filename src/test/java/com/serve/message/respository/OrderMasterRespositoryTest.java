package com.serve.message.respository;

import com.serve.message.entity.Message;
import com.serve.message.entity.OrderMaster;
import com.serve.message.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/*Created by Chandler
 *createDate:2018/2/26
 *createTime:20:07
 *测试Order与数据库是否连接成功
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterRespositoryTest {
    @Autowired
    private OrderMasterRespository respository;
@Test
    public void save(){
        UserInfo userInfo = new UserInfo();
        OrderMaster order = new OrderMaster();
        order.setMessageId("44556454");
        order.setOrderId("45678222222");
        order.setOpenId("1311111");
        order.setToOpenId("bbbbb");
        order.setTitle("代取快递");
        order.setContent("百世快递123456");
        order.setRemark("6点送到寝室");
        order.setName("Chandler");
        order.setOrderType(1);
        order.setAddress(userInfo.getAddress());
        order.setPhone(userInfo.getPhone());
        respository.save(order);
    }

    public void findOneTest(){
        OrderMaster orderMaster = respository.findOne("45678222222");
        Assert.assertNotNull(orderMaster);
    }

    public void findAllTest(){
        List<OrderMaster>orderMasterList = respository.findAll();
        Assert.assertNotEquals(0,orderMasterList.size());
    }
    @Test
    public void findByOpenId(){
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> result =  respository.findByOpenId("1311111",request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}