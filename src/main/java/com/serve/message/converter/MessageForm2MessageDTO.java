package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/22
 *createTime:11:16
 *将表单数据转换为传输对象
 */

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import com.serve.message.form.MessageForm;
import com.serve.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageForm2MessageDTO {

    public static MessageDTO convert(MessageForm messageForm){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setOpenId(messageForm.getOpenId());
        messageDTO.setTitle( messageForm.getTitle());
        messageDTO.setContent(messageForm.getContent());
        messageDTO.setRemark(messageForm.getRemark());
        messageDTO.setPhone(messageForm.getPhone());
        messageDTO.setMessageType(messageForm.getMessageType());
        return messageDTO;
    }
}
