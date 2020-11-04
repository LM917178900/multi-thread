package com.example.demo.runtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: RunController
 * @author: leiming5
 * @date: 2020-11-04 08:59
 */
@RestController
public class RunController {

    @Resource
    private RunService runService;

    @GetMapping("test/run")
    public String testxx(String id) {

        System.out.println("=========>id");
        // todo 下面的代码会异步执行
        new Thread(runService).start();
        System.out.println(id);
        return id;
    }
}
