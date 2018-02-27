package com.serve.message.controller;

import com.serve.message.VO.ResultVO;
import com.serve.message.converter.OrderFrom2OrderDTO;
import com.serve.message.dto.MessageDTO;
import com.serve.message.dto.OrderMasterDTO;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.form.OrderMasterForm;
import com.serve.message.service.MessageService;
import com.serve.message.service.OrderMasterService;
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
 *createDate:2018/2/26
 *createTime:21:57
 *用户订单Controller
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private MessageService messageService;

    //1.创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderMasterForm orderMasterForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建消息】参数不正确，oderForm={}", orderMasterForm);
            throw new ServeException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderMasterDTO orderMasterDTO = OrderFrom2OrderDTO.convert(orderMasterForm);
        MessageDTO messageDTO = messageService.findByMessageId(orderMasterDTO.getMessageId());
        if (messageDTO == null){
            log.error("【查询订单】无此订单");
            throw new ServeException(ResultEnum.ORDER_NOT_EXIST);
        }
        orderMasterDTO.setTitle(messageDTO.getTitle());
        orderMasterDTO.setToOpenId(messageDTO.getOpenId());
        OrderMasterDTO orderMasterResult = orderMasterService.create(orderMasterDTO);
        Map<String,String>map = new HashMap<>();
        map.put("orderId",orderMasterResult.getOrderId());
        return ResultVOUtil.success();
    }
    //2.查询订单（通过openid)
    @GetMapping("/list")
    public ResultVO<List<OrderMasterDTO>> listByOpenId(@RequestParam("openid") String openid,
                                                       @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                       @RequestParam(value = "size" , defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new ServeException(ResultEnum.PARAM_ERROR);
        }
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest request = new PageRequest(page,size,sort);
        Page<OrderMasterDTO> orderMasterDTOPage= orderMasterService.findByOpenIdList(openid,request);
        return  ResultVOUtil.success(orderMasterDTOPage.getContent());
    }
    //3.取消订单（暂时不开发)
    //4.修改订单（暂时不开发)
}
