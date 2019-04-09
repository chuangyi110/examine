package com.lzdn.examine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzdn.examine.dao.SignDao;
import com.lzdn.examine.entity.SignEntity;
import com.lzdn.examine.service.SignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service("signService")
public class SignServiceImpl extends ServiceImpl<SignDao,SignEntity> implements SignService {
    @Resource
    private SignDao signDao;
    @Override
    public int insert(Integer userId, String realSrc, String plateNumber, String md5) {
        String httpSrc = "/images/"+realSrc.substring(realSrc.lastIndexOf("/")+1);
        SignEntity signEntity = new SignEntity();
        signEntity.setHttpSrc(httpSrc);
        signEntity.setUploadUserId(userId);
        signEntity.setPlateNumber(plateNumber);
        signEntity.setRealSrc(realSrc);
        signEntity.setMd5(md5);
        return signDao.insertWithEntity(signEntity);
    }

    @Override
    public List<SignEntity> selectSignForOffsetPage(int limit, int offset) {
        return signDao.selectSignForOffsetPage(limit,offset);
    }

    @Override
    public int deleteByPrimaryKeys(String ids)  {
        if (ids==null&&ids.trim().isEmpty()) {
            return 0;
        }
        String[] idArray = ids.split("-");
        int num = 0;
        for (String idStr : idArray) {
            if (idStr.trim().isEmpty()) {
                continue;
            }
            Integer id = Integer.parseInt(idStr);
            SignEntity signEntity = signDao.selectById(id);
            int b = signDao.deleteById(id);
            //获取文件路径
            String realSrc = signEntity.getRealSrc();
            //文件覆盖
            FileWriter a = null;
            File file = new File(realSrc);
            long length = file.length();
            char[] bytes = new char[(int)length];
            try {
                a=new FileWriter(realSrc);
                a.write(bytes,0,bytes.length-1);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
             //路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            num = num+b;
        }
        return num;
    }
}
