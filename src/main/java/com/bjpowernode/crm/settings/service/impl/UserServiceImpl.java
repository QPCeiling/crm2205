package com.bjpowernode.crm.settings.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String loginAct, String loginPwd) {
        String md5Hex = DigestUtil.md5Hex(loginPwd, "UTF-8");
        String confusionPwd = "oweigwoeigh68546" + md5Hex + "bjpwernode";
        String saltPassword = DigestUtil.md5Hex(confusionPwd, "UTF-8");
        User user = userMapper.selectUserByLoginActAndPwd(loginAct,saltPassword);
        return ObjectUtil.isNull(user)?false:true;
    }

    @Override
    public User queryUserByLoginAct(String loginAct) {

        return userMapper.selectUserByLoginAct(loginAct);
    }
}
