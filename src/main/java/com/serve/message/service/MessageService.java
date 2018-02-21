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
//    /**
//     * 4.取消发布
//     */
//    Message cancel(Message message);
//    /**
//     * 5.支付
//     */
//    Message paid(Message message);
}
