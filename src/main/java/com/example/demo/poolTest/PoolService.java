package com.example.demo.poolTest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @description: PoolService
 * @author: leiming5
 * @date: 2020-11-04 09:36
 */
@Service
public class PoolService implements Callable<List<Integer>> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<Integer> call() throws Exception {
        boolean flag = false;
        System.out.println(Thread.currentThread().getName()+"  ");
        List<Integer> lists = new ArrayList<>();
        for(int i  = 3 ; i < 100 ; i ++) {
            flag = false;
            for(int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                lists.add(i);
            }
        }
        System.out.println(Thread.currentThread().getName()+"  task done");
        return lists;
    }
}
