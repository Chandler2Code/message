package com.serve.message.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:8:41
 *创建Message提交的表单验证
 */
@Data
public class MessageForm {
    /**
     * openid
     */
    @NotEmpty(message = "openid必填")
    private String openId;

    /**发布消息标题title */
    @NotEmpty(message = "标题必填")
    private String title;

    /**
     * 消息内容
     */
    @NotEmpty(message = "内容必填")
    private String content;

    /**
     * 备注
     */
    @NotEmpty(message = "备注必填")
    private String remark;

    /**
     * 联系方式
     */
    @NotEmpty(message = "联系方式必填")
    private String phone;
}
