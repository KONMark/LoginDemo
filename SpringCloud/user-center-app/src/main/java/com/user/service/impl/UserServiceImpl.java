package com.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.mapper.UserMapper;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author KONMark
* @description 针对表【user_info2】的数据库操作Service实现
* @createDate 2023-09-17 18:15:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




