package com.fzd.concurrency;

import jdk.nashorn.internal.scripts.JO;
import net.mindview.util.Print;

import java.nio.channels.Pipe;

/**
 * Created by FZD on 2018/6/26.
 * Description:
 */
class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            Print.print(getName() + " was interrupted." +
                    "isInterrupted(): " + isInterrupted());
        }
        Print.print(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            Print.print("Interrupted");
        }
        Print.print(getName() + " join completed");
    }
}

public class Joining{
    public static void main(String... args) {
        Sleeper
                sleepy = new Sleeper("sleepy", 1500),
                grumpy = new Sleeper("grumpy", 1500);
        Joiner
                dopey = new Joiner("dopey", sleepy),
                doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }
}
