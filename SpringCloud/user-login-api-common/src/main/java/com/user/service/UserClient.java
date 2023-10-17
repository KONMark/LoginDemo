package com.user.service;

import com.user.pojo.PostInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value="user-center-app")
public interface UserClient {

    //判断登录信息
    @PostMapping("/login")
    String login(@RequestBody PostInfo body);


}
