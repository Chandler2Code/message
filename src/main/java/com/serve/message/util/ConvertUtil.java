package com.serve.message.util;

/*Created by Chandler
 *createDate:2018/2/22
 *createTime:0:31
 *将dto数组对象转换为
 */

import com.serve.message.dto.MessageDTO;
import com.serve.message.entity.Message;
import org.springframework.beans.BeanUtils;

public class ConvertUtil {
    /**
     * 1.将entity对象转换为dto对象
     * @param message
     * @return
     */
    public static MessageDTO changeToDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        BeanUtils.copyProperties(message,messageDTO);
        return messageDTO;
    }
}
