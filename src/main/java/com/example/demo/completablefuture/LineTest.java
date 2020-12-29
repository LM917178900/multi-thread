package com.example.demo.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @description: LineTest
 * @author: leiming5
 * @date: 2020-11-09 13:55
 */
public class LineTest {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(()-> queryCode("中国石油！"));

        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync(LineTest::fetchPrice);

        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        Thread.sleep(2000);
    }

    static String queryCode(String name){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("501875");
        return name;
    }

    static Double fetchPrice(String code){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("xxx=>");
        return 5 + Math.random()* 20;
    }
}
