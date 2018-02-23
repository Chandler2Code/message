package com.serve.message.converter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*Created by Chandler
 *createDate:2018/2/23
 *createTime:9:38
 *将时间戳转换为date
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Stamp2DateTest {

    private final  String Stamp = "1519286692000";

    @Test
    public void stamp2Date() {
        String res = Stamp2Date.Stamp2Date(Stamp);
        log.info("【时间戳转换为时间】date={}",res);
    }
}