package com.serve.message.service.Impl;

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import com.serve.message.enums.MessagePayStatusEnum;
import com.serve.message.enums.MessageStatusEnum;
import com.serve.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private final String OPENID = "xxx465482";
    private final String MESSAGEID1 = "1519287397881100599";
    private final String MESSAGEID2 = "1519298469786407936";
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
        messageDTO.setMessageType("1");
        messageDTO.setOpenId("hhh4582zgb");
        MessageDTO result = messageService.create(messageDTO);
        log.info("【创建订单】result={}",result);
    }

    /**
     * 查询发布订单测试类
     */
    @Test
    public  void findOneTest(){
        MessageDTO result = messageService.findByMessageId(MESSAGEID1);
        log.info("【查询发布订单】result={}",result);
        Assert.assertNotNull(result);
    }

    /**
     * 通过openid查询订单列表
     */
    @Test
    public void findList(){
        PageRequest request = new PageRequest(0,2);
        Page<MessageDTO>messageDTOPage = messageService.findListByOpenId(OPENID,request);
        log.info("【查询列表】result={}",messageDTOPage);
        Assert.assertNotEquals(0,messageDTOPage.getTotalElements());
    }

    /**
     * 撤销订单测试类（修改订单状态）
     */
    @Test
    public void cancelTest(){
        MessageDTO messageDTO = messageService.findByMessageId(MESSAGEID1);
        MessageDTO result = messageService.cancel(messageDTO);
        Assert.assertEquals(MessageStatusEnum.CANCEL.getCode(),result.getMessageStatus());
    }

    /**
     * 支付发布费测试类
     */
    @Test
    public void payTest(){
        MessageDTO messageDTO = messageService.findByMessageId(MESSAGEID1);
        MessageDTO result = messageService.paid(messageDTO);
        Assert.assertEquals(MessagePayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
    /**
     * 查询订单是否属于当前用户
     */
    @Test
    public void checkTest(){
       MessageDTO messageDTO =  messageService.check(OPENID,MESSAGEID1);
       Assert.assertEquals(OPENID,messageDTO.getOpenId());
    }

}