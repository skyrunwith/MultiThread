package com.fzd.practice;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
class FibonacciSum implements Generator<Integer>, Callable<Integer> {
    private final int n;
    private int count;

    public FibonacciSum(int n) {
        this.n = n;
    }


    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i < n; i++) {
            sum += next();
        }
        return sum;
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}

public class E05_FibonacciSum {
    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            results.add(exec.submit(new FibonacciSum(i)));
        }
        exec.shutdown();
        for(Future<Integer> fi : results)
            try {
                System.out.println(fi.get());
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
}
