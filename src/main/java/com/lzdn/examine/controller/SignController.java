package com.lzdn.examine.controller;

import com.lzdn.examine.service.SignService;
import com.lzdn.examine.utils.FileUtil;
import com.lzdn.examine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class SignController extends AbstractController{
    Logger logger = LoggerFactory.getLogger(SignController.class);
    @Autowired
    private SignService signService;

    @RequestMapping(value = "/f/{plateNumber}",method = RequestMethod.POST)
    public R uploadImgF(HttpServletResponse res, HttpServletRequest req,MultipartFile file, @PathVariable("plateNumber")String plateNumber){
        logger.info("SignController"+file.getName()+",size:"+file.getSize());
        String initialName;
        Integer userId;
        int count=0;
        try{
            userId = Integer.parseInt(req.getParameter("userId"));
        }catch (Exception e){
            return  R.error(1,"账户信息错误，请彻底退出后重新登陆");
        }

        if(file!=null){
            initialName= file.getOriginalFilename();

            String filePath="/home/upload/sign/";
            if(!file.isEmpty()){
                String type=initialName.indexOf(".")!=-1?initialName.substring(initialName.lastIndexOf(".")+1, initialName.length()):null;
                String realSrc = FileUtil.upload(req,filePath,file,true,FileUtil.typeImg,type);
                String md5=null;
                try {
                    md5 = DigestUtils.md5DigestAsHex(new FileInputStream(realSrc));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                count  = signService.insert(userId,realSrc,plateNumber,md5);
            }
        }else {
            return R.error(1,"上传失败");
        }
        //TODO 数据落入数据库
        if(count>0){
            return R.ok().put("msg","上传成功"+count+"个照片");
        }else{
            return R.error(1,"上传失败");
        }

    }

}
