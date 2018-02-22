package com.serve.message.enums;

import lombok.Getter;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:23:23
 *返回前端异常提示
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(9,"参数不正确"),
    MESSAGE_NOT_EXIST(10,"消息不存在"),
    MESSAGEORDER_UPDATE_FAIL(11,"更新失败"),
    MESSAGEORDER_STATUS_ERROR(12,"订单状态不正确"),
    MESSAGEORDER_PAY_STATUS_ERROR(13,"订单支付状态不正确"),
    MESSAGEORDER_PAY_FAIL(14,"订单支付失败")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
