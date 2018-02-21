package com.serve.message.service.Impl;

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import com.serve.message.enums.MessageAmuontEnum;
import com.serve.message.enums.MessageStatusEnum;
import com.serve.message.enums.PayStatusEnum;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.respository.MessageRespository;
import com.serve.message.service.MessageService;
import com.serve.message.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:41
 *message方法的实现类
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRespository messageRespository;
    /**
     * 创建发布
     * @param messageDTO
     * @return
     */
    @Override
    public MessageDTO create(MessageDTO messageDTO) {
        String orderId = KeyUtil.genUniqueKey();
        messageDTO.setMessageId(orderId);
        Message message = new Message();
        BeanUtils.copyProperties(messageDTO,message);
        message.setPayStatus(PayStatusEnum.WAIT.getCode());
        message.setMessageStatus(MessageStatusEnum.NEW.getCode());
        message.setMessageAmount(MessageAmuontEnum.ORDINARY.getCode());
        messageRespository.save(message);
        return messageDTO;
    }
    /**
     * 通过发布订单id查询订单信息
     */
    @Override
    public MessageDTO findByMessageId(String messageId) {

        Message message = messageRespository.findByMessageId(messageId);
        if(message == null){
            throw new ServeException(ResultEnum.MESSAGE_NOT_EXIST);
        }
        MessageDTO messageDTO  =new MessageDTO();
        BeanUtils.copyProperties(message,messageDTO);
        return messageDTO;
    }
    /**
     * 通过openi查询订单列表
     */
}

