package com.serve.message.entity;

import com.serve.message.enums.MessageStatusEnum;
import com.serve.message.enums.MessagePayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:19:33
 *message对象
 */
@Entity
@Data
@DynamicUpdate//修改更新时间
public class Message {
    /**
     * 1.主键openid
     */
    private String openId;
    /**
     * 2.消息id
     */
    @Id
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
    private Integer messageStatus = MessageStatusEnum.NEW.getCode();
    /**
     * 10.支付状态 默认为等待支付
     */
    private Integer payStatus = MessagePayStatusEnum.WAIT.getCode();
    /**
     * 11.消息类别
     */
    private Integer messageType;
    /**
     * 12.支付金额
     */
    private BigDecimal MessageAmount = new BigDecimal(0.5);
    /**
     * 13.消息创建时间
     */
    private Date createTime;
    /**
     * 14.消息更新时间
     */
    private Date updateTime;

}
