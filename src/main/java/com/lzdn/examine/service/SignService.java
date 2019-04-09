package com.lzdn.examine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzdn.examine.entity.SignEntity;

import java.util.List;

public interface SignService extends IService<SignEntity> {
    int insert(Integer userId, String fileHttpSrc, String plateNumber, String md5);

    List<SignEntity> selectSignForOffsetPage(int limit, int offset);


    int deleteByPrimaryKeys(String ids) ;
}
