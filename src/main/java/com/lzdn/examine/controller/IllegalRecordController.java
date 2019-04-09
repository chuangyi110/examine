package com.lzdn.examine.controller;

import com.lzdn.examine.entity.VehicleEntity;
import com.lzdn.examine.entity.ViolationInformationEntity;
import com.lzdn.examine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 违法记录查询
 *
 */
@RestController
public class IllegalRecordController extends AbstractController{
    Logger logger = LoggerFactory.getLogger(IllegalRecordController.class);

    /**
     * wfjl 违法记录
     *
     */
    @RequestMapping("/wfjl")
    public Object illegalRecord(VehicleEntity vehicleEntity){
        logger.info("传入参数："+vehicleEntity.toString());
        if(vehicleEntity.getPlateNumber().equals("辽D66B67")){
            ViolationInformationEntity v1 = new ViolationInformationEntity();
            v1.setViolation("不按规定停车");
            v1.setViolationSite("沈阳市高科路新程街");
            v1.setPoint("0");
            v1.setPenalty("200");
            v1.setType("2");
            ViolationInformationEntity v2 = new ViolationInformationEntity();
            v2.setViolation("驾驶人未按规定使用安全带");
            v2.setViolationSite("胜利南大街南三马路");
            v2.setPoint("0");
            v2.setPenalty("20");
            v2.setType("2");
            List<ViolationInformationEntity> list = new ArrayList <>();
            list.add(v1);
            list.add(v2);
            logger.info("传入参数："+vehicleEntity+",返回参数："+list);
            return R.ok().put("wfjl",list);
        }else {
            logger.info("传入参数："+vehicleEntity+",返回参数：未查询到记录");
            return R.error(1,"未查询到记录");
        }

    }
}
