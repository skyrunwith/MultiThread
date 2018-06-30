package com.fzd.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
public class E04_Fibonacci2 {
    public static void main(String... args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =1; i<= 5; i++){
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for(int i =1; i<= 5; i++){
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for(int i =1; i<= 5; i++){
            exec.execute(new Fibonacci(i));
        }
        Thread.yield();
        exec.shutdown();
    }
}
