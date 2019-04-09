package com.lzdn.examine.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzdn.examine.dao.UserDao;
import com.lzdn.examine.entity.TransportEntity;
import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;
import com.lzdn.examine.service.UserService;
import com.lzdn.examine.utils.R;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginAppController extends AbstractController{
    Logger logger = LoggerFactory.getLogger(LoginAppController.class);
    @Autowired
    UserService userService;
    @Resource
    UserDao userDao;

    @RequestMapping("/login")
    public R login(TransportEntity transportEntity){
        logger.info(transportEntity.toString());
        String tramsport;
        try{
            tramsport=  new String(Base64.decode(transportEntity.getTransport()));
        }catch (Exception e){
            return R.error(1,"参数错误");
        }
        LoginForm loginForm = JSON.parseObject(tramsport,new TypeReference <LoginForm>(){});
        UserEntity userEntity = userService.getOne(
                new QueryWrapper <UserEntity>().eq("username",loginForm.getUsername())
        );
        String pwdInForm = loginForm.getPassword().trim();
        if (!pwdInForm.isEmpty()&&pwdInForm.equals(userEntity.getPassword())){
            if(userEntity.getStatue()==0){
                userEntity.setPassword("");
                return  R.ok("成功").put("user",userEntity);
            }else{
                return R.error(1,"账号已被锁定");
            }
        }
        return R.error(1,"账号密码错误");
    }

//    public static void main(String[] args) {
//        String s = Base64.encode("pwdA".getBytes());
//        System.out.println(s);
//    }
}
