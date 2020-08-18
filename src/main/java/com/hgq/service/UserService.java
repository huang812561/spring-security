package com.hgq.service;

import com.hgq.dao.role.PerssionMapper;
import com.hgq.dao.user.UserMapper;
import com.hgq.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.hgq.service.UserService
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 16:20
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PerssionService perssionService;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("用户验证,登录名：{}", userName);
//        明文验证
//        UserDetails userDetails = User.withUsername("hgq").password("123").authorities("p1").build();
//        UserDetails userDetails = User.withUsername("hgq").password("$2a$10$G96t61tlW1ExYPfgWKmvMuKhCVGcDzyprDasE0StnOkSOHEm7P5eC").authorities("p1").build();
        UserEntity userEntity = userMapper.queryUserByName(userName);
        UserDetails userDetails = null;
        if(null != userEntity){
            /*userDetails = User.withUsername(userEntity.getUserName())
                    .password(userEntity.getPassword())
                    .authorities("p1")
                    .build();*/
            List<String> perssionCodeList = perssionService.getUserPerssionList(userEntity.getId());
            String[] perssionArray = new String[perssionCodeList.size()];
            if(!perssionCodeList.isEmpty()){
                perssionCodeList.toArray(perssionArray);
            }
            userDetails = User.withUsername(userEntity.getUserName())
                    .password(userEntity.getPassword())
                    .authorities(perssionArray)
                    .build();
        }

        return userDetails;
    }

    /**
     * 从SecurityContextHolder上下文中获取用户名
     *
     * @return
     */
    public String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object object = authentication.getPrincipal();
        String userName = "";
        if(object instanceof UserDetails){
            UserDetails userDetails = (UserDetails) object;
            userName = userDetails.getUsername();
        }
        return userName;
    }
}
