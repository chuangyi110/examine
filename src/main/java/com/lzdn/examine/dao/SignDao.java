package com.lzdn.examine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzdn.examine.entity.SignEntity;
import com.lzdn.examine.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SignDao extends BaseMapper<SignEntity>{
    int insertWithEntity(SignEntity signEntity);

    List<SignEntity> selectSignForOffsetPage(@Param("limit") int limit, @Param("offset")int offset);
}
