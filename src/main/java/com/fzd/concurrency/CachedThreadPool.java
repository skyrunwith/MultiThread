package com.fzd.concurrency;

import com.fzd._21_2.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
public class CachedThreadPool {
    public static void main(String... args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
