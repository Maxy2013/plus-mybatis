package com.plus.mybatis.perfect.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plus.mybatis.perfect.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

    int insertUser(User user);


    List<User> selectUser(User user);

    User selectOneUser(User user);

    User selectUserHost(User user);
}
