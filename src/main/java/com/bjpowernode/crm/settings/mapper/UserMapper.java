package com.bjpowernode.crm.settings.mapper;

import com.bjpowernode.crm.settings.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByLoginActAndPwd(@Param("loginAct") String loginAct, @Param("saltPassword") String saltPassword);

    User selectUserByLoginAct(String loginAct);
}