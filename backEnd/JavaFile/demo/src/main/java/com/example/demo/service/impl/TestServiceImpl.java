package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import com.example.demo.util.ReturnUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-14 21:19
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    TestMapper testMapper;

    @Override
    public JSONObject queryTest(int id) {
        try {
            return ReturnUtil.returnObj("查询成功", 0, testMapper.queryTest(id));
        }catch (Exception e) {
            Logger.getLogger("c.s.i.TestServiceImpl").warning(e.toString());
            return ReturnUtil.returnObj("查询失败", -1, null);
        }
    }
}
