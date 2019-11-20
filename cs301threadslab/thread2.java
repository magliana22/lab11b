package edu.up.cs301threadslab;

import java.util.Random;

public class thread2 extends Thread {
    private StarAnimation star;

    public thread2(StarAnimation star) {
        this.star = star;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (star) {
                    //critical section
                    Random num = new Random();
                    int addOrRemove = num.nextInt(2);
                    if (addOrRemove == 0) {
                        star.addStar();
                    } else {
                        star.removeStar();
                    }
                    Thread.sleep(2);
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
