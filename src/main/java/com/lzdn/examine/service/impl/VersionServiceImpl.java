package com.lzdn.examine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzdn.examine.dao.VersionDao;
import com.lzdn.examine.entity.VersionEntity;
import com.lzdn.examine.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

@Service("versionService")
public class VersionServiceImpl extends ServiceImpl<VersionDao,VersionEntity> implements VersionService{
    @Resource
    private VersionDao versionDao;
    @Override
    public VersionEntity selectNew() {
        VersionEntity versionEntity = versionDao.selectNew();
        System.out.println(versionEntity);
        return versionEntity;
    }


}
