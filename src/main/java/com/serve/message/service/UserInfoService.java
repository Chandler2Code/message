package com.serve.message.service;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:10:18
 *
 */

import com.serve.message.dto.UserInfoDTO;
import com.serve.message.entity.UserInfo;

public interface UserInfoService {
    /**
     * 1.通过openid查询订单
     * @param openid
     * @return
     */
    UserInfoDTO findByOpenid(String openid);
    /**
     * 2.修改联系方式和地址
     */
    UserInfoDTO  updateInfo(UserInfoDTO userInfoDTO);
    /**
     * 3.新增用户
     */
    UserInfoDTO addUser(UserInfoDTO userInfoDTO);
    /**
     * 修改用户信息（仅对于地址和联系方式的修改）
     */
    UserInfoDTO updateUserInfo(UserInfoDTO userInfoDTO);
}
