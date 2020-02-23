package com.plus.mybatis.perfect.business.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.plus.mybatis.perfect.mapper.UserMapper;
import com.plus.mybatis.perfect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    public String testService(String str) {

        return str + "传入的参数是：【" + str + "】";
    }


    public List<User> queryTest() {
        List<User> users = userMapper.selectList(Wrappers.<User>query()
                .eq(false, "list", "123").orderByAsc("l_345"));
        System.out.println(users.size());
        return users;
    }

    public List<User> queryTestRedis() {
        List<User> users = userMapper.selectList(Wrappers.<User>query());
//        redisTemplate.opsForValue().set("12345", users);
        System.out.println(users.size());
        return users;
    }

    public List<User> queryTestRedisGet() {
        Object obj = redisTemplate.opsForValue().get("12345");
        if(!ObjectUtils.isEmpty(obj)){
            return (List<User>)obj;
        }else {
            List<User> users = userMapper.selectList(Wrappers.<User>query());
            System.out.println(users.size());
            return users;
        }
    }

    public void template() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("unit", "XXXX单位");
        dataMap.put("year", "2019");
        dataMap.put("month", "12");
        dataMap.put("date", "23");
        dataMap.put("Seq", "1");
        dataMap.put("Name", "小刚");
        dataMap.put("Sex", "男");
        dataMap.put("Job", "驾驶员");
        dataMap.put("Time", "3");
        dataMap.put("leaderSign", "小吉君");

    }

}
