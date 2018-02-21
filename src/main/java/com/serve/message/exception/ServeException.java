package com.serve.message.exception;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:23:21
 *统一异常处理
 */

import com.serve.message.enums.ResultEnum;

public class ServeException extends RuntimeException{
    private Integer code;

    public ServeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }

    public ServeException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
