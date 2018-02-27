package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:9:57
 *
 */
@Getter
public enum UserInfoCerStatusEnum {
    NEW(0,"已经认证"),
    CANCEL(1,"未认证")
    ;

    private Integer code;
    private String   msg;

    UserInfoCerStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
