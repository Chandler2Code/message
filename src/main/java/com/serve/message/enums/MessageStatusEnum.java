package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:19:41
 *新消息状态枚举
 */
@Getter
public enum MessageStatusEnum {
    NEW(0,"新发布"),
    CANCEL(1,"撤销发布")
    ;

    private Integer code;
    private String   msg;

    MessageStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
