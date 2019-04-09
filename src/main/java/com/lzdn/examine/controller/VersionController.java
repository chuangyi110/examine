package com.lzdn.examine.controller;

import com.lzdn.examine.entity.VersionEntity;
import com.lzdn.examine.service.VersionService;
import com.lzdn.examine.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VersionController extends AbstractController {
    @Autowired
    private VersionService versionService;

    @RequestMapping("/localVersion")
    public R getVersion(String localVersion){
        VersionEntity versionEntity = versionService.selectNew();
        if((!localVersion.isEmpty())&&
                localVersion.equals(versionEntity.getVersionCode().toString())){
            return R.ok();
        }
        return R.error(1,"请更新版本，最新版本为："+versionEntity.getVersionName());
    }
}
