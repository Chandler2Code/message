package com.serve.message.service.Impl;

import com.serve.message.dto.UserInfoDTO;
import com.serve.message.entity.UserInfo;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.respository.UserInfoRespository;
import com.serve.message.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:10:24
 *用户个人信息修改
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRespository respository;
    @Override
    public UserInfoDTO findByOpenid(String openid) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        UserInfo userInfo = respository.findOne(openid);
        if (userInfo == null){
            log.error("【用户信息查询】查无此人");
            throw new ServeException(ResultEnum.PARAM_ERROR);
        }
        BeanUtils.copyProperties(userInfo,userInfoDTO);
        return userInfoDTO;
    }

    @Override
    @Transactional
    public UserInfoDTO updateInfo(UserInfoDTO userInfoDTO) {
       UserInfo userInfo = respository.findOne(userInfoDTO.getOpenId());
       if (userInfo == null){
           log.error("【用户信息查询】查无此人，无法更改个人信息");
           throw new ServeException(ResultEnum.PARAM_ERROR);
       }
       userInfo.setAddress(userInfoDTO.getAddress());
       userInfo.setPhone(userInfoDTO.getPhone());
       respository.save(userInfo);
       return userInfoDTO;
    }
    /**
     * 新增用户
     */
    @Override
    public UserInfoDTO addUser(UserInfoDTO userInfoDTO) {
        UserInfo userInfo =new UserInfo();
        BeanUtils.copyProperties(userInfoDTO,userInfo);
        respository.save(userInfo);
        return userInfoDTO;
    }
    /**
     * 修改信息(地址和联系方式）
     */
    @Override
    public UserInfoDTO updateUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo =respository.findOne(userInfoDTO.getOpenId());
        if (userInfo == null){
            log.error("【查用户】此用户没有进行微信授权");
            throw new ServeException(ResultEnum.PARAM_ERROR);
        }
        userInfo.setPhone(userInfoDTO.getPhone());
        userInfo.setAddress(userInfoDTO.getAddress());
        BeanUtils.copyProperties(userInfo,userInfoDTO);
        respository.save(userInfo);
        return userInfoDTO;
    }
}
