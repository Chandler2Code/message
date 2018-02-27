package com.serve.message.controller;

import com.serve.message.VO.ResultVO;
import com.serve.message.converter.MessageForm2MessageDTO;
import com.serve.message.dto.MessageDTO;
import com.serve.message.dto.UserInfoDTO;
import com.serve.message.entity.UserInfo;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.form.AlterMessageStatus;
import com.serve.message.form.MessageForm;
import com.serve.message.service.MessageService;
import com.serve.message.service.UserInfoService;
import com.serve.message.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Created by Chandler
 *createDate:2018/2/20
 *createTime:20:59
 *消息发布的controller实现
 */
@RestController
@Slf4j
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private UserInfoService userInfoService;

    //创建发布消息
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid MessageForm messageForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("【创建消息】参数不正确，messageForm={}",messageForm);
            throw new ServeException(ResultEnum.PARAM_ERROR.getCode(),
                                     bindingResult.getFieldError().getDefaultMessage());
        }

        //TODO 创建一个用户对象
        MessageDTO messageDTO = MessageForm2MessageDTO.convert(messageForm);
        /**
         * 手工输入用户信息，后面或专门构造一个用户对象用户传输用户信息  在service层实现
         */
        //TODO must
        UserInfoDTO userInfoDTO = userInfoService.findByOpenid(messageDTO.getOpenId());
        if (userInfoDTO == null){
            log.error("【查询用户】该用户没有授权此微信平台");
            throw new ServeException(ResultEnum.PARAM_ERROR);
        }
        messageDTO.setName(userInfoDTO.getWechatName());
        messageDTO.setAvater(userInfoDTO.getAvater());
        MessageDTO  createResult =messageService.create(messageDTO);

        Map<String,String> map = new HashMap<>();
        map.put("messageId",createResult.getMessageId());
        return ResultVOUtil.success(map);
    }
    //查询发布列表--通过openid
    @GetMapping("/list")
    public ResultVO<List<MessageDTO>> listByOpenId(@RequestParam("openid") String openid,
                                                   @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                   @RequestParam(value = "size" , defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new ServeException(ResultEnum.PARAM_ERROR);
        }
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest request = new PageRequest(page,size,sort);
        Page<MessageDTO>messageDTOPage = messageService.findListByOpenId(openid,request);
        return  ResultVOUtil.success(messageDTOPage.getContent());
    }
    //查询发布列表--直接查询
    @GetMapping("/all")
    public ResultVO<List<MessageDTO>> allMessage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size",defaultValue = "3") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest request = new PageRequest(page,size,sort);
        Page<MessageDTO>messageDTOPage = messageService.findListByStatus(0,request);
        return ResultVOUtil.success(messageDTOPage.getContent());
    }
    //通过消息id查询数据
    @GetMapping("/detial")
    public ResultVO messageDetail(@RequestParam("messageId") String messageId){
        MessageDTO messageDTO = messageService.findByMessageId(messageId);
        if(messageDTO == null){
            log.error("【查询消息详细】无此消息");
            throw new ServeException(ResultEnum.MESSAGE_NOT_EXIST);
        }
        return ResultVOUtil.success(messageDTO);
    }
    //取消发布（修改订单状态）
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openId") String openId,
                           @RequestParam("messageId")String messageId){
        /**
         * 判断messageId是否属于该用户
         */
        MessageDTO messageDTO = messageService.check(openId,messageId);
        messageService.cancel(messageDTO);
        return ResultVOUtil.success();
    }
    @PostMapping("/cancel2")
    public ResultVO cancel(@Valid AlterMessageStatus messageStatus,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建消息】参数不正确，messageStatus={}",messageStatus);
            throw new ServeException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        MessageDTO messageDTO = messageService.check(messageStatus.getOpenId(),messageStatus.getMessageId());
        messageService.cancel(messageDTO);
        return ResultVOUtil.success();

    }
}
