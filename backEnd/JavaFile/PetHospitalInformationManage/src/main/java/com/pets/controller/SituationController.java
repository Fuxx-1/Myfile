package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.Situation;
import com.pets.service.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * program: PetHospitalInformationManage
 * description:
 *
 * @author Fuxx-1
 * create: 2022-04-09 15:51
 **/
@Controller
@ResponseBody
@RequestMapping("/Situation")
@CrossOrigin
public class SituationController {

    @Autowired
    SituationService situationService;

    @RequestMapping("/add")
    public String addSituation(@RequestBody Situation situation) {
        return situationService.addSituation(situation).toJSONString();
    }

    @RequestMapping("/complete")
    public String completeSituation(@RequestBody Situation situation) {
        return situationService.completeSituation(situation.getSituationid(), situation.getRectificateid()).toJSONString();
    }

    @RequestMapping("/update")
    public String updateRectificate(@RequestBody Situation situation) {
        return situationService.updateRectificate(situation.getSituationid(), situation.getRectificateid()).toJSONString();
    }

    @RequestMapping("/updateInf")
    public String updateInf(@RequestBody Situation situation) {
        return situationService.updateInf(situation).toJSONString();
    }

    @RequestMapping("/query")
    public String querySituation(Situation situation) {
        return situationService.querySituation(situation.getHospitalId()).toJSONString();
    }
}
