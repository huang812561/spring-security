package com.hgq.service;

import com.hgq.dao.role.PerssionMapper;
import com.hgq.entity.UserPerssionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName com.hgq.service.PerssionService
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-17 15:25
 * @Version: 1.0
 */
@Service
public class PerssionService {

    @Autowired
    private PerssionMapper perssionMapper;

    /**
     * 获取用户权限列表
     *
     * @param userId
     * @return
     */
    public List<String> getUserPerssionList(String userId){
        List<String> resultList= null;
        List<UserPerssionEntity> userPerssionEntityList = perssionMapper.queryPerssionByUserId(userId);
        if(!userPerssionEntityList.isEmpty()){
            resultList = userPerssionEntityList.stream().map(userPerssionEntity -> userPerssionEntity.getPerssionCode()).collect(Collectors.toList());
        }
        return resultList;
    }

}
