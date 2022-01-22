package com.xl.aopdemo.aop.controller;

import com.xl.aopdemo.aop.annotations.Permissions;
import com.xl.aopdemo.aop.vo.RestApiResultVo;
import com.xl.aopdemo.aop.vo.StudentQueryVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aop")
public class AopTestController {

    @GetMapping("getTest")
    public int getTest () {

        return 1/0;
    }

    @PostMapping("postTest")
    public void postTest () {
        System.out.println("Post Request Is Running");
    }

    @PostMapping("testAround")
    @Permissions
    public RestApiResultVo testAround (@RequestBody StudentQueryVo param) {
        Integer id = param.getId();
        String name = param.getName();
        String age = param.getAge();
        System.out.println("id: "+id+"name: "+name+"age: "+age);
        return RestApiResultVo.ok(param);
    }
}
