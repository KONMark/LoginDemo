package com.user.strategy.Impl;


import com.user.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//策略4:至少一个特殊符号
@Component
public class JudgeSymbol  implements Strategy {

    @Override
    public Result JudgePassword(String password) {
        Pattern pattern = Pattern.compile("[~!@#$%^&*]+");
        Matcher matcher = pattern.matcher(password);
        System.out.println("执行JudgeSymbol");
//        return matcher.find();
        Result result = new Result();
        result.setSuccess(matcher.find());
        result.setMessage("密码需要至少一位特殊符号");
        return result;
    }
    @Override
    public String getType() {
        return "JudgeSymbol";
    }
}
