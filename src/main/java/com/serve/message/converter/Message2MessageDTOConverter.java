package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/22
 *createTime:8:48
 *实体对象与传输对象之间的转化
 */

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Message2MessageDTOConverter {
    /**
     * 将实体转换为传输
     * @param message
     * @return
     */
    public static MessageDTO convert(Message message){
        MessageDTO messageDTO = new MessageDTO();
        BeanUtils.copyProperties(message,messageDTO);
        return messageDTO;
    }

    /**
     * 将实体数组转换为传输数组
     * @param messageList
     * @return
     */
    public static List<MessageDTO> convert(List<Message>messageList){
        return messageList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
