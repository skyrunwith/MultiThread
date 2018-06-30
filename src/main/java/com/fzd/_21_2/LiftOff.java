package com.fzd._21_2;

/**
 * Created by FZD on 2018/6/20.
 * Description:
 */
public class LiftOff implements Runnable
{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? +countDown : "LifOff!") + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String... args){
//        LiftOff liftOff = new LiftOff();
//        liftOff.run();

        for(int i =0; i < 1; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
