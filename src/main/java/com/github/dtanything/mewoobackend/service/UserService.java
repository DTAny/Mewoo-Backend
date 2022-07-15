package com.github.dtanything.mewoobackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.dtanything.mewoobackend.pojo.User;

/**
* @author DT_Anything
* @description 针对表【user】的数据库操作Service
* @createDate 2022-07-13 19:20:24
*/
public interface UserService extends IService<User> {
    boolean verifyUser(User user);
}
