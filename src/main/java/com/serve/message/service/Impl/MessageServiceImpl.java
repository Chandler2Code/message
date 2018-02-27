package com.serve.message.service.Impl;

import com.serve.message.converter.Message2MessageDTOConverter;
import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import com.serve.message.enums.MessageAmuontEnum;
import com.serve.message.enums.MessageStatusEnum;
import com.serve.message.enums.MessagePayStatusEnum;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.respository.MessageRespository;
import com.serve.message.service.MessageService;
import com.serve.message.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        message.setPayStatus(MessagePayStatusEnum.WAIT.getCode());
        message.setMessageStatus(MessageStatusEnum.NEW.getCode());
        message.setMessageAmount(MessageAmuontEnum.ORDINARY.getCode());
        messageRespository.save(message);
        return messageDTO;
    }
    /**
     * 通过发布订单id查询发布订单信息
     */
    @Override
    public MessageDTO findByMessageId(String messageId) {

        Message message = messageRespository.findByMessageId(messageId);
        if(message == null){
            throw new ServeException(ResultEnum.ORDER_NOT_EXIST);
        }
        MessageDTO messageDTO  =new MessageDTO();
        BeanUtils.copyProperties(message,messageDTO);
        return messageDTO;
    }
    /**
     * 通过openid查询发布订单列表(分页查询)
     */
    @Override
    public Page<MessageDTO> findListByOpenId(String openid, Pageable pageable) {
        Page<Message>messagePage = messageRespository.findByOpenId(openid,pageable);
        List<MessageDTO>messageDTOList = Message2MessageDTOConverter.convert(messagePage.getContent());
        return new PageImpl<MessageDTO>(messageDTOList,pageable,messagePage.getTotalElements());
    }
    /**
     * 查询所有发布消息（包含在线和非在线所有发布）
     * TODO  用SpecificationExecutor实现按照天数查找
     */
    @Override
    public Page<MessageDTO> findList(Pageable pageable) {
        Page<Message> messagePage = messageRespository.findAll(pageable);
        List<MessageDTO>messageDTOList = Message2MessageDTOConverter.convert(messagePage.getContent());
        return new PageImpl<MessageDTO>(messageDTOList,pageable,messagePage.getTotalElements());
    }
    /**
     * 查询所有在线发布
     */
    @Override
    public Page<MessageDTO> findListByStatus(Integer status, Pageable pageable) {
        Page<Message>messagePage = messageRespository.findByMessageStatus(status,pageable);
        List<MessageDTO>messageDTOList = Message2MessageDTOConverter.convert(messagePage.getContent());
        return new PageImpl<MessageDTO>(messageDTOList,pageable,messagePage.getTotalElements());
    }

    /**
     * 撤销发布  修改发布订单的状态
     */
    @Override
    public MessageDTO cancel(MessageDTO messageDTO) {
        Message message = new Message();
        messageDTO.setMessageStatus(MessageStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(messageDTO,message);
        Message updateResult =  messageRespository.save(message);
        if(updateResult == null){
            log.error("【更新失败】message = {}",message);
            throw new ServeException(ResultEnum.MESSAGE_NOT_EXIST);
        }
        return messageDTO;
    }
    /**
     * 支付发布费
     */
    @Override
    @Transactional
    public MessageDTO paid(MessageDTO messageDTO) {
        //1.判断订单状态
        if(!messageDTO.getMessageStatus().equals(MessageStatusEnum.NEW.getCode())){
            log.error("【订单已支付并撤销发布】订单状态不正确messageStatus = {}",messageDTO.getMessageStatus());
            throw new ServeException(ResultEnum.MESSAGEORDER_STATUS_ERROR);
        }
        //2.判断支付状态
        if(!messageDTO.getPayStatus().equals(MessagePayStatusEnum.WAIT.getCode())){
            log.error("【订单已经支付，不能重复支付】订单支付状态不正确messagePayStatus = {}",messageDTO.getPayStatus());
            throw new ServeException(ResultEnum.MESSAGEORDER_PAY_STATUS_ERROR);
        }
        //3.修改支付状态
        Message message = new Message();
        messageDTO.setPayStatus(MessagePayStatusEnum.SUCCESS.getCode());
        BeanUtils.copyProperties(messageDTO,message);
        Message updateResult =  messageRespository.save(message);
        if(updateResult == null){
            log.error("【订单支付失败】message = {}",message);
            throw new ServeException(ResultEnum.MESSAGEORDER_PAY_FAIL);
        }
        return messageDTO;
    }
    /**
     * 查询订单是否属于本人
     */
    @Override
    public MessageDTO check(String openid, String messageid) {
        MessageDTO messageDTO = new MessageDTO();
        Message message = messageRespository.findByMessageId(messageid);
        if(message == null){
            log.error("【订单查询】无该订单");
            throw new ServeException(ResultEnum.ORDER_NOT_EXIST);
        }
        BeanUtils.copyProperties(message,messageDTO);
        if (!messageDTO.getOpenId().equals(openid)){
            log.error("【查询订单】订单openid不一致openid={},messageDTO={}",openid,messageDTO);
            throw new ServeException(ResultEnum.MESSAGEORDER_OWNER_ERROR);
        }
        return messageDTO;
    }
}

