package com.hgq.entity;

import lombok.Data;

/**
 * @ClassName com.hgq.entity.UserEntity
 * @Description: 用户类
 * @Author: hgq
 * @Date: 2020-08-17 14:25
 * @Version: 1.0
 */
@Data
public class UserEntity extends BaseEntity{

   private String id;
   private String userName;
   private String nickName;
   private String password;
   private String phone;
   private String sex;
   private String age;
   private String address;

}
