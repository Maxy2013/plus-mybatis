package com.plus.mybatis.perfect.business.controller;

import com.plus.mybatis.perfect.business.service.ExcelService;
import com.plus.mybatis.perfect.business.service.TestService;
import com.plus.mybatis.perfect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/restfulTest")
    public String restfulTest(String param) {

        return testService.testService(param);
    }

    @GetMapping("/queryTestData")
    public List<User> queryTestData() {

        return testService.queryTest();
    }

    @GetMapping("/queryTestRedis")
    public List<User> queryTestRedis() {
        return testService.queryTestRedis();
    }

    @GetMapping("/queryTestRedisGet")
    public List<User> queryTestRedisGet() {

        return testService.queryTestRedisGet();
    }

    @GetMapping("/getUserExcel")
    public String getUserExcel() throws Exception {

        return excelService.getUserExcel();
    }

    @GetMapping("/transPdf")
    public String transPdf() throws Exception {

        return excelService.toPdf();
    }
}
