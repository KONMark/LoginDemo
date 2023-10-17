package com.user.strategy.Impl;

import com.user.strategy.Strategy;
import org.springframework.stereotype.Component;


//策略1：长度不少于6,不多于20
@Component
public class JudgeLength implements Strategy {

    @Override
    public Result JudgePassword(String password) {
        System.out.println("执行JudgeLength");
//        return password.length()>=6&&password.length()<=20?true:false;
        Result result = new Result();
        result.setSuccess(password.length()>=6&&password.length()<=20?true:false);
        result.setMessage("密码长度不合规，长度要在6~20内");
        return result;
    }

    @Override
    public String getType() {
        return "JudgeLength";
    }

}
