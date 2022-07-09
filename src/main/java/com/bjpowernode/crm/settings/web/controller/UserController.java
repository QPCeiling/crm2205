package com.bjpowernode.crm.settings.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.bjpowernode.crm.commons.constant.AppConstants;
import com.bjpowernode.crm.commons.enums.RespCode;
import com.bjpowernode.crm.commons.resp.Result;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:
 * Package:com.bjpowernode.crm.settings.web.controller
 * author:郭鑫
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin() {
        return "settings/qx/user/login";
    }

    @RequestMapping("/settings/qx/user/login.do")
    public @ResponseBody Object login(HttpServletRequest request,
                                      @RequestParam("loginAct") String loginAct,
                                      @RequestParam("loginPwd") String loginPwd){
        Result result = Result.ERROR();

        try{
            if(!userService.login(loginAct,loginPwd)){
                result.setRespCode(RespCode.ACT_PWD_NOT_MATCH);
                return result;
            }

            User userInfo = userService.queryUserByLoginAct(loginAct);
            if(ObjectUtil.isNotNull(userInfo)){
                request.getSession().setAttribute(AppConstants.SESSION_USER, userInfo);
            }

            result = Result.SUCCESS();

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }

        return result;
    }
}
