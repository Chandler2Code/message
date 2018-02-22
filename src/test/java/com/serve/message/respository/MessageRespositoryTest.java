package com.serve.message.respository;

import com.serve.message.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:11
 *测试数据库是否连通
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MessageRespositoryTest {
    @Autowired
    private MessageRespository respository;


    @Test
    public void saveTest(){
        Message message = new Message();
        message.setOpenId("abcdefg");
        message.setMessageId("123456789");
        message.setTitle("寄快递");
        message.setContent("代取校园周边各大快递，2元/件，送至寝室，货到付款");
        message.setRemark("只服务于11公寓的汉子哈");
        message.setPhone("18382469064");
        message.setAvater("http://www.xw.qqcom.xxfj");
        message.setName("Jack");
        message.setMessageType("0");
        respository.save(message);
    }

    @Test
    public void findByOpenId(){
        PageRequest request = new PageRequest(0,1);
        Page<Message> result =  respository.findByOpenId("abcdefg",request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void findByMessageId(){
        Message message = respository.findByMessageId("1519298469786407936");
        log.info("【查询发布消息】message={}",message);
        Assert.assertNotNull(message);
    }

    /**
     * 通过时间查询数据
     */
    @Test
    public void findAll(){
        PageRequest request = new PageRequest(0,10);
        Page<Message>messagePage = respository.findAll(request);
        Assert.assertNotEquals(0,messagePage.getTotalElements());
    }

}