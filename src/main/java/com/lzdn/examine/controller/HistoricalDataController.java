package com.lzdn.examine.controller;

import com.lzdn.examine.entity.Item;
import com.lzdn.examine.entity.VehicleEntity;
import com.lzdn.examine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  历史数据调取
 */
@RestController
public class HistoricalDataController extends AbstractController{
    Logger logger = LoggerFactory.getLogger(HistoricalDataController.class);
    /**
     *  历史记录
     *
     */
    @RequestMapping("/h")
    public Object illegalRecord(VehicleEntity vehicleEntity){
        logger.info("传入参数："+vehicleEntity.toString());
        if(vehicleEntity.getPlateNumber().equals("辽D66B67")){
            List<Item> codeList = new ArrayList<Item>();
            codeList.add(new Item("1","润滑油页面标准","合格","合乎标准",false));
            codeList.add(new Item("1","润滑油页面标准","合格","合乎标准",false));
            codeList.add(new Item("1","润滑油页面标准","合格","合乎标准",false));
            Map map = new HashMap();
            map.put("obj",codeList);
            return R.ok(map);
        }else {
            logger.info("传入参数："+vehicleEntity+",返回参数：未查询到记录");
            return R.error(1,"未查询到记录");
        }

    }

}
