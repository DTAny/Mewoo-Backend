package com.github.dtanything.mewoobackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.dtanything.mewoobackend.mapper.UserMapper;
import com.github.dtanything.mewoobackend.pojo.User;
import com.github.dtanything.mewoobackend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
* @author DT_Anything
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-07-13 19:20:24
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public boolean verifyUser(User user) {
        String name = user.getUsername();
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return null != getOne(wrapper
                .eq("username", name)
                .eq("password", pwd)
        );
    }
}




