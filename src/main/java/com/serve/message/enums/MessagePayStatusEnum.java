package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:19:51
 *支付状态枚举
 */
@Getter
public enum MessagePayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private String   msg;

    MessagePayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
