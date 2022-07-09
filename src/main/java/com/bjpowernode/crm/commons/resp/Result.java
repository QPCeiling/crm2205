package com.bjpowernode.crm.commons.resp;

import com.bjpowernode.crm.commons.enums.RespCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer code;
    private String message;
    private Object body;

    public void setRespCode(RespCode respCode){
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    public static Result SUCCESS(){
        Result result = new Result();
        //result.setCode(1000);
        //result.setMessage("请求成功");
        result.setRespCode(RespCode.SUCCESS);
        result.setBody("");
        return result;
    }

    public static Result ERROR(){
        Result result = new Result();
        //result.setCode(9999);
        //result.setMessage("请求异常,请稍后重试");
        result.setRespCode(RespCode.FAILURE);
        result.setBody("");
        return result;
    }
}
