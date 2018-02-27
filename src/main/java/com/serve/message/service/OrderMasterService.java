package com.serve.message.service;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:20:41
 *
 */

import com.serve.message.dto.OrderMasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderMasterService {
    /**
     * 1.创建订单
     */
    OrderMasterDTO create(OrderMasterDTO orderMasterDTO);
    /**
     * 2.通过openid查询订单
     */
    Page<OrderMasterDTO> findByOpenIdList(String openid, Pageable pageable);
    /**
     * 3.通过订单id查询订单
     */
    OrderMasterDTO findByOrderId(String orderid);

}
