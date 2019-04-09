package com.lzdn.examine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    int stopUser(String username);

    UserEntity selectUserByLoginForm(LoginForm loginForm);

    List<UserEntity> selectByUserForOffsetPage(@Param("limit") int limit, @Param("offset") int offset);

    int addUser(UserEntity userEntity);

    UserEntity selectByUserId(String id);
}
