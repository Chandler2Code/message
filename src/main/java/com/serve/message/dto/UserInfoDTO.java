package com.serve.message.dto;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:10:21
 *
 */

import com.serve.message.enums.UserInfoCerStatusEnum;
import lombok.Data;

import java.util.Date;
@Data
public class UserInfoDTO {
    private String openId ;
    private String wechatName;
    /**
     * 微信头像
     */
    private String avater;
    private String address;
    private String phone;
    /**
     * 用户认证情况 0为已经认证
     */
    private Integer certificationStatus = UserInfoCerStatusEnum.NEW.getCode();
    /**
     * createTime  进入时间
     */
    private Date createTime;
    /**
     * .updateTime 更新时间（更新地址或者微信头像等信息）
     */
    private Date updateTime;
}
