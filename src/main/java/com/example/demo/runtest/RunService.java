package com.example.demo.runtest;

import org.springframework.stereotype.Service;

/**
 * @description: xxService
 * @author: leiming5
 * @date: 2020-11-04 09:00
 */
@Service
public class RunService implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("=========>runnable");
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
