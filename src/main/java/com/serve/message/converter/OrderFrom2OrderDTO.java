package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:22:10
 *订单：将表单数据转换为对象
 */

import com.serve.message.dto.OrderMasterDTO;
import com.serve.message.form.OrderMasterForm;

public class OrderFrom2OrderDTO {

    public static OrderMasterDTO convert(OrderMasterForm orderMasterForm){
        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
        orderMasterDTO.setOpenId(orderMasterForm.getOpenId());
        orderMasterDTO.setContent(orderMasterForm.getContent());
        orderMasterDTO.setRemark(orderMasterForm.getRemark());
        orderMasterDTO.setAddress(orderMasterForm.getAddress());
        orderMasterDTO.setPhone(orderMasterForm.getPhone());
        orderMasterDTO.setName(orderMasterForm.getName());
        orderMasterDTO.setOrderType(1);
        orderMasterDTO.setMessageId(orderMasterForm.getMessageId());
       return orderMasterDTO;
    }
}
