package com.serve.message.service;


import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:30
 *message的逻辑层
 */
public interface MessageService {
    /**
     * 1.创建发布
     * @return
     */
    MessageDTO create(MessageDTO messageDTO);
    /**
     * 2.查询单个发布
     */
    MessageDTO findByMessageId(String messageId);
    /**
     * 3.通过openid查询发布列表
     */
    Page<MessageDTO>findListByOpenId(String openid, Pageable pageable);
    /**
     * 4.查询所有发布
     */
    Page<MessageDTO>findList(Pageable pageable);
    /**
     * 5.查询所有在线发布
     */
    Page<MessageDTO>findListByStatus(Integer status, Pageable pageable);
    /**
     * 5.取消发布
     */
    MessageDTO cancel(MessageDTO messageDTO);
    /**
     * 6.支付发布费
     */
    MessageDTO paid(MessageDTO messageDTO);
    /**
     * 7.查询订单是否属于本人
     */
    MessageDTO check(String openid,String messageid);
}
