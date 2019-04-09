package com.lzdn.examine.controller;

import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;
import com.lzdn.examine.service.UserService;
import com.lzdn.examine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.calendar.BaseCalendar;

@Controller
@RequestMapping("/web")
public class LoginH5Controller extends AbstractController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public R login(LoginForm loginForm){
        logger.info(loginForm.toString());
        UserEntity userEntity = userService.selectUserByLoginForm(loginForm);
        if(userEntity!=null){
            if(loginForm.getPassword().equals(userEntity.getPassword())){
                if(userEntity.getType()==0){
                    R r = R.ok();
                    r.put("url","/web/index");
                    return r;
                }else{
                    return  R.error(1,"该用户无权访问");
                }

            }
        }
        return R.error(1,"账号密码错误！");
    }
}
