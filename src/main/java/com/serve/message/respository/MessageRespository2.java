package com.serve.message.respository;

/*Created by Chandler
 *createDate:2018/2/22
 *createTime:22:21
 *
 */

import com.serve.message.entity.Message;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRespository2 extends JpaSpecificationExecutor<Message> {
    
}
