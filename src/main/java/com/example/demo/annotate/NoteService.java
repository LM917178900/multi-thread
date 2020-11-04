package com.example.demo.annotate;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @description: NoteService
 * @author: leiming5
 * @date: 2020-11-04 14:37
 */
@Service
public class NoteService {

    // 这里可以注入spring中管理的其他bean，这也是使用spring来实现多线程的一大优势

    // @Async 定义一个线程任务
    @Async    // 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public void f1(int i) {
        System.out.println("f1 : "+ i +":" + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void f2(int i) {
        System.out.println("f2 : " + i +":" + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
