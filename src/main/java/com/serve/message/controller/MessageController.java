package com.serve.message.controller;

import com.serve.message.form.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:59
 *消息发布的controller实现
 */
@RestController
@Slf4j
@RequestMapping("/message")
public class MessageController {

    //创建发布消息
    @PostMapping("/create")
    public void create(@Valid MessageForm messageForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("【创建消息】参数不正确，messageForm={}",messageForm);
        }
    }
    //查询发布列表
    //取消发布（修改订单状态）
}
