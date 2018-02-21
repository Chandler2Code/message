package com.serve.message.VO;

import lombok.Data;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:21:24
 *返回值
 */
@Data
public class ResultVO <T> {
    /**返回码*/
    private Integer code;
    /*返回消息*/
    private String msg;
    /*返回实际值*/
    private T data;
}
