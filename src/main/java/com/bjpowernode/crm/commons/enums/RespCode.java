package com.bjpowernode.crm.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RespCode {

    SUCCESS(1000,"请求成功"),
    FAILURE(9999,"请求异步,请稍后重试"),
    ACT_PWD_NOT_MATCH(1501,"账号密码不匹配"),


    ;

    private Integer code;
    private String message;

}
