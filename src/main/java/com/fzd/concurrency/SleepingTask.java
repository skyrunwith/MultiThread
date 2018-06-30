package com.fzd.concurrency;

import com.fzd._21_2.LiftOff;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
public class SleepingTask extends LiftOff {
    public void run(){
        while (countDown-- > 0){
            System.out.println(status());
            try {
//                Thread.sleep(100);
                Random random = new Random();
                TimeUnit.MICROSECONDS.sleep(random.nextInt(10) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0; i < 5; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
