package com.lzdn.examine.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzdn.examine.entity.VersionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface VersionDao extends BaseMapper<VersionEntity> {
    VersionEntity selectNew();
}
