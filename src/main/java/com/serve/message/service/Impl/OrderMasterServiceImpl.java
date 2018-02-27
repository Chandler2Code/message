package com.serve.message.service.Impl;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:20:56
 *
 */

import com.serve.message.converter.OrderMaster2OrderMasterDTOConverter;
import com.serve.message.dto.OrderMasterDTO;
import com.serve.message.entity.Message;
import com.serve.message.entity.OrderMaster;
import com.serve.message.enums.MessageAmuontEnum;
import com.serve.message.enums.MessagePayStatusEnum;
import com.serve.message.enums.MessageStatusEnum;
import com.serve.message.enums.ResultEnum;
import com.serve.message.exception.ServeException;
import com.serve.message.respository.OrderMasterRespository;
import com.serve.message.service.OrderMasterService;
import com.serve.message.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterRespository orderMasterRespository;

    /**
     * 1.创建订单
     * @param orderMasterDTO
     * @return
     */
    @Override
    public OrderMasterDTO create(OrderMasterDTO orderMasterDTO) {
        String orderId = KeyUtil.genUniqueKey();
        orderMasterDTO.setOrderId(orderId);
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderMasterDTO,orderMaster);
        orderMasterRespository.save(orderMaster);
        return orderMasterDTO;
    }

    /**
     * 2.通过openid查询订单
     */
    @Override
    public Page<OrderMasterDTO> findByOpenIdList(String openid, Pageable pageable) {
        Page<OrderMaster>orderMasterPage = orderMasterRespository.findByOpenId(openid,pageable);
        List<OrderMasterDTO>orderMasterDTOList = OrderMaster2OrderMasterDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<OrderMasterDTO>(orderMasterDTOList,pageable,orderMasterPage.getTotalElements());
    }

    /**
     * 3.通过messageId查询订单
     */
    @Override
    public OrderMasterDTO findByOrderId(String orderid) {

        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
       OrderMaster orderMaster =  orderMasterRespository.findByOrderId(orderid);
       if (orderMaster == null){
           log.error("【查询订单为】数据库内无该订单");
           throw  new ServeException(ResultEnum.ORDER_NOT_EXIST);
       }
       BeanUtils.copyProperties(orderMaster,orderMasterDTO);
       return orderMasterDTO;
    }
}
