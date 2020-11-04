package com.example.demo.callabletest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: CallController
 * @author: leiming5
 * @date: 2020-11-04 09:23
 */
@RestController
public class CallController {

    @Resource
    private CallService callService;

    @GetMapping("test/call")
    public String testxx(String id) throws ExecutionException, InterruptedException {

        System.out.println("=========>id");

        // todo 下面的代码会同步执行；
        FutureTask futureTask = new FutureTask(callService);
        new Thread(futureTask).start();

        Object o = futureTask.get();
        System.out.println(o.toString());

        System.out.println(id);
        return id;
    }
}
