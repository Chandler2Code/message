package com.serve.message.enums;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:22:03
 *支付价格枚举
 */

import lombok.Getter;

import java.math.BigDecimal;
@Getter
public enum MessageAmuontEnum {
    ORDINARY(new BigDecimal(0.5),"普通订单")
    ;
    private BigDecimal code;
    private String   msg;

    MessageAmuontEnum(BigDecimal code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
