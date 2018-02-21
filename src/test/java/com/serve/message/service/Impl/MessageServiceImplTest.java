package com.serve.message.service.Impl;

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import com.serve.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;


/*Created by Chandler
 *createDate:2018/2/21
 *createTime:21:09
 *MessageService测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;
    /**
     * 创建订单测试类
     */
    @Test
    public void create() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTitle("代取快递");
        messageDTO.setContent("代取校园周边各大快递，2元/件，送至寝室，货到付款");
        messageDTO.setRemark("只服务于11公寓的汉子哈");
        messageDTO.setName("Chandler");
        messageDTO.setAvater("http://www.xw.qqcom.xxfj");
        messageDTO.setPhone("18382469064");
        messageDTO.setMessageType(1);
        messageDTO.setOpenId("xxx465482");
        MessageDTO result = messageService.create(messageDTO);
        log.info("【创建订单】result={}",result);
    }

    /**
     * 查询发布订单测试类
     */
    @Test
    public  void findOneTest(){
        String messageId = "151922223845423064";
        MessageDTO result = messageService.findByMessageId(messageId);
        log.info("【查询发布订单】result={}",result);
        Assert.assertNotNull(result);
    }
}