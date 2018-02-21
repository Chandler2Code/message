package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:23:23
 *返回前端异常提示
 */
@Getter
public enum ResultEnum {
    MESSAGE_NOT_EXIST(10,"消息不存在")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
