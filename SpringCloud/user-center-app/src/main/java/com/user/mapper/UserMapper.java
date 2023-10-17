package com.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author KONMark
* @description 针对表【user_info2】的数据库操作Mapper
* @createDate 2023-09-17 18:15:42
* @Entity com.user.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




