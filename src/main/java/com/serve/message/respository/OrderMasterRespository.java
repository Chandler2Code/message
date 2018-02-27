package com.serve.message.respository;

/*Created by Chandler
 *createDate:2018/2/26
 *createTime:20:05
 *订单jpa
 */

import com.serve.message.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRespository extends JpaRepository<OrderMaster,String>{
    Page<OrderMaster> findByOpenId(String openid, Pageable pageable);
    OrderMaster findByOrderId(String orderid);
}
