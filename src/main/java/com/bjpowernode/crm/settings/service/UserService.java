package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.User;

public interface UserService {
    boolean login(String loginAct, String loginPwd);

    User queryUserByLoginAct(String loginAct);
}
