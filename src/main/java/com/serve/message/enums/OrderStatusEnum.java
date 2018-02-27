package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:20:12
 *订单状态枚举
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新下单"),
    CANCEL(1,"取消订单")
    ;

    private Integer code;
    private String   msg;

    OrderStatusEnum (Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
