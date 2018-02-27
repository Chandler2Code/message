package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:12:38
 *获取个人信息表单转换为DTO
 */

import com.serve.message.dto.UserInfoDTO;
import com.serve.message.form.UpdateUserInfoForm;

public class UserInfoFrom2UserInfoDTOConverter {
    public static UserInfoDTO convert(UpdateUserInfoForm userInfoForm){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setOpenId(userInfoForm.getOpenid());
        userInfoDTO.setAddress(userInfoForm.getAddress());
        userInfoDTO.setPhone(userInfoForm.getPhone());
        return userInfoDTO;
    }
}
