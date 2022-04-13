package com.pets.controller;

import com.pets.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-28 18:42
 **/
@Controller
@ResponseBody
@RequestMapping("/Summary")
@CrossOrigin
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @RequestMapping("/getInfCount")
    String getInfCount(boolean isToday, boolean hasHospital, boolean isAll){
        return summaryService.getInfCount(isToday, hasHospital, isAll).toJSONString();
    }

}
