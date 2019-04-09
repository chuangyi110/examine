package com.lzdn.examine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;

import java.util.List;

public interface UserService extends IService<UserEntity> {

    int stopUser(String username);

    UserEntity selectUserByLoginForm(LoginForm loginForm);

    List<UserEntity> selectByUserForOffsetPage(int limit, int offset);

    int addUser(UserEntity userEntity);

    UserEntity selectByUserId(String id);
}
