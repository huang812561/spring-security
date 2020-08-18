package com.hgq.dao.user;

import com.hgq.entity.UserEntity;


/**
 * @Decription：
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 17:50
 * @Version 1.0
 */
public interface UserMapper {

    UserEntity queryUserByName(String userName);
}
