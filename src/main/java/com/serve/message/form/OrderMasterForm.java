package com.serve.message.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:22:03
 *用户创建订单表单验证
 */
@Data
public class OrderMasterForm {

    @NotEmpty(message = "消息id为空")
    private String messageId;
    @NotEmpty(message = "openid必填")
    private String openId;
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "联系方式必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "内容必填")
    private String content;
//    @NotEmpty(message = "订单类型必填")
//    private Integer orderType;
    /**
     * 备注用户选填
     */
    private String remark;

}
