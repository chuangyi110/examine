package com.lzdn.examine.service;




import com.baomidou.mybatisplus.extension.service.IService;
import com.lzdn.examine.entity.VersionEntity;

import java.util.Map;

public interface VersionService extends IService<VersionEntity> {
    VersionEntity selectNew();
}
