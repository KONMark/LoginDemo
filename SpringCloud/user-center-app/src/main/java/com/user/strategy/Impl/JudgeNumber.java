package com.user.strategy.Impl;

import com.user.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//策略2：判断是否存在数字
@Component
public class JudgeNumber implements Strategy {

    @Override
    public Result JudgePassword(String password) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(password);
        System.out.println("执行JudgeNumber");
//        return matcher.matches();
        Result result = new Result();
        result.setSuccess(matcher.matches());
        result.setMessage("密码需要至少一位数字");
        return result;
    }
    @Override
    public String getType() {
        return "JudgeNumber";
    }
}
