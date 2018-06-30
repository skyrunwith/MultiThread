package com.fzd.concurrency;

import java.io.IOException;

/**
 * Created by FZD on 2018/6/27.
 * Description:
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws IOException {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    public void run(){
        while (true){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String... args) throws IOException {
//        new UnresponsiveUI(); //must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d); //shows progress
    }
}
