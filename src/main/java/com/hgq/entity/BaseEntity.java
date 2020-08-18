package com.hgq.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.hgq.entity.BaseEntity
 * @Description: 基类
 * @Author: hgq
 * @Date: 2020-08-17 14:25
 * @Version: 1.0
 */
@Data
public class BaseEntity extends AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标识
     */
    private String delFlag = "0";
}
