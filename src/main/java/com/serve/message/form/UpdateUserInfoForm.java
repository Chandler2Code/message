package com.serve.message.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:12:32
 *用户更新信息
 */
@Data
public class UpdateUserInfoForm {
    @NotEmpty(message = "用户id为空")
    private String openid;
    @NotEmpty(message = "用户地址必填")
    private String address;
    @NotEmpty(message = "用户联系方式必填")
    private String phone;
}
