package com.hgq.entity;

import lombok.Data;

/**
 * @ClassName com.hgq.entity.UserPerssionEntity
 * @Description: 用户权限关系表
 * @Author: hgq
 * @Date: 2020-08-17 14:38
 * @Version: 1.0
 */
@Data
public class UserPerssionEntity extends BaseEntity {
    private String userId;
    private String perssionCode;
}
