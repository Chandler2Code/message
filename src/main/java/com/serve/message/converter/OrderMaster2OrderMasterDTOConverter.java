package com.serve.message.converter;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:21:19
 *将实体数组转化为传输数组
 */

import com.serve.message.dto.OrderMasterDTO;
import com.serve.message.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderMasterDTOConverter {


    /**
     * 将实体转换为传输
     * @param orderMaster
     * @return
     */
    public static OrderMasterDTO convert(OrderMaster orderMaster){
        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
        BeanUtils.copyProperties(orderMaster,orderMasterDTO);
        return orderMasterDTO;
    }
    /**
     * 将实体数组转换为传输数组
     * @param orderMasterList
     * @return
     */
    public static List<OrderMasterDTO> convert(List<OrderMaster>orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
