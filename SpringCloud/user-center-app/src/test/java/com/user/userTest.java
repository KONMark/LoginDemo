package com.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.mapper.UserMapper;
import com.user.pojo.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userTest {

    @Autowired
    UserMapper userMapper;
    
    @Test
    @DisplayName("JudgeUsername")
    public boolean judgeusername(){
        String username = "000";
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        long num = userMapper.selectCount(queryWrapper);
        if(num == 0)        //说明该用户名没有被注册过
            return true;
        else                //一般来说就是>0的情况，说明有被注册过那么就无法通过，<0或>1则为异常情况也不予通过。
            return false;
    }

}
