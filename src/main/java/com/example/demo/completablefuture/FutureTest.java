package com.example.demo.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @description: FutureTest
 * @author: leiming5
 * @date: 2020-11-09 13:25
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(FutureTest::fetchPrice);

        cf.thenAccept((result)->{
            System.out.println("price=======>" + result);
        });

        cf.exceptionally((e)->{
            e.printStackTrace();
            return null;
        });
        Thread.sleep(200);
    }

    static Double fetchPrice(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Math.random() <0.3){
            throw new RuntimeException("fetch price fail!");
        }
        return 5+ Math.random()*20;

    }
}
