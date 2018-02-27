package com.serve.message.controller;

import com.serve.message.VO.ResultVO;
import com.serve.message.converter.UserInfoFrom2UserInfoDTOConverter;
import com.serve.message.dto.UserInfoDTO;
import com.serve.message.entity.UserInfo;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.form.UpdateUserInfoForm;
import com.serve.message.service.UserInfoService;
import com.serve.message.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:11:10
 *用户个人信息的修改Controller
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 修改、新增地址
     */
    @PostMapping("/update")
    public ResultVO updateUserInfo(@Valid UpdateUserInfoForm userInfoForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建消息】参数不正确，messageForm={}",userInfoForm);
            throw new ServeException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        UserInfoDTO userInfoDTO = UserInfoFrom2UserInfoDTOConverter.convert(userInfoForm);
        UserInfoDTO userInfoDTOResult = userInfoService.updateInfo(userInfoDTO);
        return ResultVOUtil.success();
    }
    /**
     * 通过openid查询个人信息
     */
    @GetMapping("/information")
    public ResultVO findInfo(@RequestParam("openid") String openid){

        UserInfoDTO userInfoDTO = userInfoService.findByOpenid(openid);
        if (userInfoDTO == null){
//            return ResultVOUtil.error(1,"该用户没有授权此公众号");
            log.error("【查询用户】该用户没有微信授权给此公众号");
            throw new ServeException(ResultEnum.USER_ERROR);

        }
        return ResultVOUtil.success(userInfoDTO);
    }
}
