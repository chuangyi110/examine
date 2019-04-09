package com.lzdn.examine.controller;

import com.lzdn.examine.entity.UserEntity;
import com.lzdn.examine.form.LoginForm;
import com.lzdn.examine.service.UserService;
import com.lzdn.examine.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexH5Controller extends AbstractController{
    @Autowired
    private UserService userService;

    @RequestMapping(value="/web/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/web/getUser",method = RequestMethod.GET)
    @ResponseBody
    public R getData(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit){
        System.out.println("limit："+limit+"offset："+offset);
        List<UserEntity> list = userService.selectByUserForOffsetPage(limit,offset);
        int total = userService.count();
        //System.out.println("List:"+list+"total:"+total);
        return R.ok().put("rows",list).put("total",total);
    }
    @RequestMapping(value = "/web/index/add",method = RequestMethod.GET)
    public String addView(){
        return "index/add";
    }
    @RequestMapping(value = "/web/index/add",method = RequestMethod.POST)
    @ResponseBody
    public R add(UserEntity userEntity){

        userEntity.setStatue(0);
        System.out.println(userEntity);
        int count = userService.addUser(userEntity);
        if(count>0){
            return R.ok();
        }
        return R.error(1,"内部异常请重试");
    }

    @RequestMapping(value = "/web/index/update/{id}",method = RequestMethod.GET)
    public String updateView(@PathVariable("id")String id,HttpServletRequest req,HttpServletResponse res,Model model){
        UserEntity userEntity = userService.selectByUserId(id);
        System.out.println(userEntity);
        model.addAttribute("user",userEntity);
        return "index/update";
    }
    @RequestMapping(value = "/web/index/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public R update(UserEntity userEntity){
        System.out.println(userEntity);
        boolean b = userService.updateById(userEntity);
        return R.ok();
    }

}
