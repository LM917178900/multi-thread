package com.example.demo.callabletest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @description: CallService
 * @author: leiming5
 * @date: 2020-11-04 09:23
 */
@Service
public class CallService implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() throws Exception {
        boolean flag = false;
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
        return lists;
    }

}
