package com.example.demo.threadtest;

import org.springframework.stereotype.Service;

/**
 * @description: ThreadService
 * @author: leiming5
 * @date: 2020-11-04 09:12
 */
@Service
public class ThreadService extends Thread{

    @Override
    public void run() {
        boolean flag = false;
        for(int i  = 3 ; i < 100 ; i ++) {
            flag = false;
            for(int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                System.out.print(i+"  ");
            }
        }
    }

}
