package com.example.demo.poolTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: PollController
 * @author: leiming5
 * @date: 2020-11-04 09:36
 */
@RestController
public class PoolController {

    @Resource
    private PoolService poolService;

    @GetMapping("test/pool")
    public void testxx(String id) throws ExecutionException, InterruptedException {

        // 1.创建固定大小的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int size = 5;
        // 2.修改创建线程池的方式（Executor-->ThreadPoolExecutor）
//        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());

        // 3.添加线程池的名字
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),namedThreadFactory);



        List<Future<List<Integer>>> ints = new ArrayList<>();
        for(int i = 0 ; i < 5; i ++) {

            // todo 会异步执行poolService，（同一个线程内是同步的，线程之间异步交叉执行）
            // 提交多个线程任务，并执行
            Future<List<Integer>> future = executorService.submit(poolService);
            ints.add(future);
        }

        // 关闭线程池
        executorService.shutdown();

        // todo 如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
        // 任务已经执行完成，单纯的获取执行结果；
        for (Future<List<Integer>> future : ints) {
            System.out.println(future.get());
        }
    }
}
