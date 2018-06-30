package com.fzd.practice;

import net.mindview.util.Generator;

import java.util.Arrays;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
class Fibonacci implements Generator<Integer>, Runnable{
    private int count;
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        Integer[] sequence = new Integer[n];
        for(int i =0; i < n; i++){
            sequence[i] = next();
        }
        System.out.println(
                "Seq. of " + n + ": " + Arrays.toString(sequence));
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n){
        if(n < 2) return 1;
        return fib(n-2) + fib(n - 1);
    }
}

public class E02_Fibonacci {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++)
            new Thread(new Fibonacci(i)).start();
    }
}
