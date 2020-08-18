package com.hgq.dao.role;

import com.hgq.entity.UserPerssionEntity;

import java.util.List;

/**
 * @ClassName com.hgq.dao.role.PerssionMapper
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-17 14:39
 * @Version: 1.0
 */
public interface PerssionMapper {

    List<UserPerssionEntity> queryPerssionByUserId(String userId);
}
