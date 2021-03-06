package com.serve.message.entity;

import com.serve.message.enums.OrderStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:17:21
 *订单entity
 */
@Entity
@Data
@DynamicUpdate//更新修改时间
public class OrderMaster {
    /**
     * 1.messageId
    */
    @Id
     private String orderId;
     /**
     * 2.openId
     */
    private String openId;
    /**
     * 3.toOpenId
     */
    private String toOpenId;
    /**
     * 4.content
     */
    private String content;
    /**
     * 5.title
     */
    private String title;
    /**
     * 6.remark
     */
    private String remark;
    /**
     * 7.orderStatus 订单状态
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 8.orderType
     */
    private Integer orderType;
    /**
     * 9.name
     */
    private String name;
    /**
     * 10.phone
     */
    private String phone;
    /**
     * 11.address 收货地址
     */
    private String address;
    /**
     * 12.createTime 创建时间
     */
    private Date createTime;
    /**
     * 13.updateTime 更新时间
     */
    private Date updateTime;
    /**
     * 14.messageID 消息id
     */
    private String messageId;
}