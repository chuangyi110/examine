package com.lzdn.examine.controller;

import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.service.UserService;
import com.lzdn.examine.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractController{
    @Autowired
    private UserService userService;

    @RequestMapping("/user/lock")
    public R lockUser(String username){
        int num = userService.stopUser(username);
        if(num==1){
            return R.ok("用户已锁定");
        }else {
            return R.error(1,"未知错误");
        }
    }
}
