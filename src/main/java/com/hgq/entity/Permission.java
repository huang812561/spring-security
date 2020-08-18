package com.hgq.entity;

import lombok.Data;

/**
 * @ClassName com.hgq.entity.Permission
 * @Description: 权限
 * @Author: hgq
 * @Date: 2020-08-17 14:25
 * @Version: 1.0
 */
@Data
public class Permission extends BaseEntity{

    private String id;
    private String perssion_code;
    private String perssion_name;
    private String perssion_url;
}
