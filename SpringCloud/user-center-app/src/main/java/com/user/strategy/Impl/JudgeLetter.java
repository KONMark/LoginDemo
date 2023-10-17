package com.user.strategy.Impl;

import com.user.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//策略3：字母存在且包含大小写
@Component
public class JudgeLetter implements Strategy {

    @Override
    public Result JudgePassword(String password) {
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z]).*");
        Matcher matcher = pattern.matcher(password);
        System.out.println("执行JudgeLetter");
//        return matcher.matches();
        Result result = new Result();
        result.setSuccess(matcher.matches());
        result.setMessage("密码需要字母以及大小写");
        return result;
    }
    @Override
    public String getType() {
        return "JudgeLetter";
    }
}
