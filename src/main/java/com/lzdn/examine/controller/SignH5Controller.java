package com.lzdn.examine.controller;

import com.lzdn.examine.entity.SignEntity;
import com.lzdn.examine.service.SignService;
import com.lzdn.examine.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class SignH5Controller extends AbstractController {
    @Autowired
    private SignService signService;

    @RequestMapping("/sign")
    public String sign(){
        return "sign";
    }
    @RequestMapping(value = "/getSign",method = RequestMethod.GET)
    @ResponseBody
    public R getData (
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit){
        List<SignEntity> list = signService.selectSignForOffsetPage(limit,offset);
        int total = signService.count();
        return R.ok().put("rows",list).put("total",total);
    }
    @RequestMapping(value = "/sign/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public R deleteByIds(@PathVariable("ids")String ids){
        int count = signService.deleteByPrimaryKeys(ids);
        return R.ok().put("msg",count);
    }



}
