package com.user.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.user.pojo.PostInfo;
import com.user.service.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RefreshScope
public class AuthCenterController {

    @Resource
    private UserClient userClient;

    @Value("${token.key}")
    private String tokenKey;

    HashMap<String, Object> tokenMap = new HashMap<>();

    @PostMapping("/login")
    String login(@RequestBody PostInfo body){
        return userClient.login(body);
    }

    //token 测试
    @GetMapping("/token")
    public String token(){
        PostInfo body = new PostInfo("001","abcABC123!");
        tokenMap.put("username",body.getUsername());
        tokenMap.put("password",body.getPassword());
        String token = JWTUtil.createToken(tokenMap,tokenKey.getBytes());
        return token;
    }



}
