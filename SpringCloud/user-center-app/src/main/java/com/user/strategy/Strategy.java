package com.user.strategy;

import lombok.Data;

//策略方法：Strategy接口（保存密码判断的所有策略）
 /*
    当注册用户时，需要判断密码：
    1.长度不少于6,不多于20
    2.存在数字
    3.字母存在且包含大小写
    4.至少一个特殊符号；
    当然，我想在用户登录界面实时输入的时候，也能用这些策略去判断，因为学了ajax
 */
public interface Strategy {
    public Result JudgePassword(String password);      //对判断密码这一个行为，实现不同的判断策略
    public String getType();

    @Data
    public static class Result{
        private boolean success;
        private String message;
    };
}
