package com.serve.message.dto;

/*Created by Chandler
 *createDate:2018/2/21
 *createTime:20:56
 *消息传输中间量
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.serve.message.util.serializer.Date2LongSerializer;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
@Data
public class MessageDTO {
    /**
     * 1.主键openid
     */
    private String openId;
    /**
     * 2.消息id
     */
    private String messageId;
    /**
     * 3.消息标题
     */
    private String title;
    /**
     * 4.消息内容
     */
    private String content;
    /**
     * 5.消息备注
     */
    private String remark;
    /**
     * 6.发布消息人的微信名称
     */
    private String name;
    /**
     * 7.发布消息人的微信头像
     */
    private String avater;
    /**
     * 8.发布消息人的联系方式
     */
    private String phone;
    /**
     * 9.消息发布的状态  默认为新订单
     */
    private Integer messageStatus;
    /**
     * 10.支付状态 默认为等待支付
     */
    private Integer payStatus;
    /**
     * 11.消息类别
     */
    private String messageType;
    /**
     * 12.支付金额
     */
    private BigDecimal MessageAmount ;
    /**
     * 13.消息创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**
     * 14.消息更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
