package com.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.mapper.UserMapper;
import com.user.pojo.PostInfo;
import com.user.pojo.User;
import com.user.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class UserCenterController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ApplicationContext applicationContext;

    static Map<String, Strategy> smap = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Strategy> map = applicationContext.getBeansOfType(Strategy.class);
        map.values().forEach(v -> {
            smap.put(v.getType(), v);
        });
        smap.values().forEach(v -> {
            System.out.println("Type:" + v.getType() + " Class:" + v.getClass());
        });
    }

    //判断登录信息
    @PostMapping("/login")
    public String login(@RequestBody PostInfo body){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",body.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(user==null)
            return "用户名不存在";
        if(user.getPassword().equals(body.getPassword()))
            return "登录成功！";
        return "密码错误！";
    }

    //判断用户名是否唯一，用于注册
    @PostMapping("/judgeusername")
    public String judgeusername(@RequestBody String username) throws UnsupportedEncodingException {
        String username1 = URLDecoder.decode(username, "UTF-8");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username1);
        long num = userMapper.selectCount(queryWrapper);
        if(num == 0)        //说明该用户名没有被注册过
            return "账号合规！";
        else                //一般来说就是>0的情况，说明有被注册过那么就无法通过，<0或>1则为异常情况也不予通过。
            return "账号已存在！";
    }

    //注册
    @PostMapping("/register")
    public boolean register(@RequestBody PostInfo body){
        User user = new User();
        user.setUsername(body.getUsername());
        user.setPassword(body.getPassword());
        int result = userMapper.insert(user);      //插入方法会返回插入行数
        if (result == 1) {
            return true;
        } else
            return false;

    }


    /**
     * 四个判断密码策略，都要包括，但是显示有优先级
     * 1.判断长度
     * 2.判断数字
     * 3.判断字母
     * 4.判断特殊字符
     *
     * @param password
     * @return
     */
    @PostMapping("/judgePassword")
    public String judgePassword(@RequestBody String password) {
        try {
            //ASCII码判断
            System.out.println(password);
//            String password1 = URLDecoder.decode(password, "UTF-8");        // % -->%25
//            System.out.println(password1);
            List<Strategy> list = new LinkedList<>();
            list.add(smap.get("JudgeLength"));
            list.add(smap.get("JudgeNumber"));
            list.add(smap.get("JudgeLetter"));
            list.add(smap.get("JudgeSymbol"));

            list.forEach(strategy -> {
                Strategy.Result result = strategy.JudgePassword(password);
                if (!result.isSuccess())
                    throw new RuntimeException(result.getMessage());
            });
        } catch (Exception e) {
            return e.getMessage();
        }
        return "密码合规!";
    }

}
