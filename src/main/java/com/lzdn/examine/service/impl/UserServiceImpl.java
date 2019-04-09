package com.lzdn.examine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzdn.examine.dao.UserDao;
import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;
import com.lzdn.examine.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao,UserEntity> implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public int stopUser(String username) {
        int num = userDao.stopUser(username);
        return num;
    }

    @Override
    public UserEntity selectUserByLoginForm(LoginForm loginForm) {
        UserEntity userEntity = userDao.selectUserByLoginForm(loginForm);
        return userEntity;
    }

    @Override
    public List<UserEntity> selectByUserForOffsetPage(int limit, int offset) {

        return userDao.selectByUserForOffsetPage(limit,offset);
    }

    @Override
    public int addUser(UserEntity userEntity) {
        return userDao.addUser(userEntity);
    }

    @Override
    public UserEntity selectByUserId(String id) {
        return userDao.selectByUserId(id);
    }
}
