package com.example.demo.threadtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: ThreadController
 * @author: leiming5
 * @date: 2020-11-04 09:14
 */
@RestController
public class ThreadController {

    @Resource
    private ThreadService threadService;

    @GetMapping("test/thread")
    public String test_01(String id){

        System.out.println("=========>id");
        // todo 下面的代码会异步执行；
        new Thread(threadService).start();
        System.out.println(id);
        return id;
    }
}
