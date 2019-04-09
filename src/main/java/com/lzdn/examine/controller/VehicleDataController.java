package com.lzdn.examine.controller;

import com.lzdn.examine.entity.VehicleTableModel;
import com.lzdn.examine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VehicleDataController extends AbstractController {
    Logger logger = LoggerFactory.getLogger(IllegalRecordController.class);

    @RequestMapping("/getData/{plateNumber}")
    public R getData(@PathVariable("plateNumber")String plateNumber){
        if(plateNumber.equals("辽D66B67")){
            List<VehicleTableModel> codeList = new ArrayList<VehicleTableModel>();
            codeList.add(new VehicleTableModel("1","轴数","4","合乎标准",false));
            codeList.add(new VehicleTableModel("1","轴距","1800","单位为毫米（mm）",false));
            Map map = new HashMap();
            map.put("obj",codeList);
            return R.ok(map);
        }else{
            return R.error(404101,"暂未发现车辆数据");
        }

    }

}
