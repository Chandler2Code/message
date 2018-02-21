package com.serve.message.respository;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:10
 *
 */

import com.serve.message.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRespository extends JpaRepository<Message,String> {
    Message findByMessageId(String MessageId);
    Page<Message> findByOpenId(String openid, Pageable pageable);
}