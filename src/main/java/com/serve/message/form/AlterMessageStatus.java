package com.serve.message.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:9:27
 *提交修改内容
 */
@Data
public class AlterMessageStatus {
    /**
     * 用户openid
     */
    @NotEmpty(message = "openid必填")
    private String openId;
    /**
     * 用户消息订单id
     */
    @NotEmpty(message = "messageId必填")
    private String messageId;
}
