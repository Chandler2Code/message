package com.serve.message.respository;

/*Created by Chandler
 *createDate:2018/2/27
 *createTime:9:53
 *
 */

import com.serve.message.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRespository extends JpaRepository<UserInfo,String> {

}
