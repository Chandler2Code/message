package com.serve.message.service.Impl;

import com.serve.message.dto.UserInfoDTO;
import com.serve.message.entity.UserInfo;
import com.serve.message.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*Created by Chandler
 *createDate:2018/2/27
 *createTime:10:35
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;
    private final String OPENID = "xxx52634";
//    @Test
    public void findByOpenid() {
        UserInfoDTO userInfoDTO = userInfoService.findByOpenid(OPENID);
        Assert.assertNotNull(userInfoDTO);
    }

//    @Test
    public void updateInfo() {
        UserInfoDTO userInfoDTO = userInfoService.findByOpenid(OPENID);
        userInfoDTO.setAddress("成都中医药大学温江校区11公寓324寝室");
        userInfoDTO.setPhone("18382469065");
        userInfoService.updateInfo(userInfoDTO);
    }
    @Test
    public void addUserTest(){
        UserInfoDTO userInfoDTO =new UserInfoDTO();
        userInfoDTO.setWechatName("MarDin");
        userInfoDTO.setAvater("http://www.imooc.com");
        userInfoDTO.setOpenId("zbalidk46fdc2c3c");
        userInfoService.addUser(userInfoDTO);
    }
    @Test
    public void updateUserTest(){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setOpenId("xcf5824620");
        userInfoDTO.setPhone("18382469064");
        userInfoDTO.setAddress("5公寓524寝室");
    }
}