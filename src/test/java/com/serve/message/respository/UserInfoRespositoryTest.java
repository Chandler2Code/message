package com.serve.message.respository;

import com.serve.message.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*Created by Chandler
 *createDate:2018/2/27
 *createTime:9:54
 *用户信息库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRespositoryTest {
    @Autowired
    private UserInfoRespository respository;
    @Test
    public void saveTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId("xxx52634");
        userInfo.setAvater("http://www.czone.com");
        userInfo.setPhone("18382469064");
        userInfo.setAddress("成都中医药大学温江校区11公寓323寝室");
        userInfo.setWechatName("Chandler");
        respository.save(userInfo);
    }
}