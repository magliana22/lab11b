package edu.up.cs301threadslab;
import java.lang.Thread;

public class thread1 extends java.lang.Thread{
    Thread t;
    private AnimationView AV;
    public StarAnimation starAnim;

    public thread1(AnimationView v, StarAnimation starAn){
        AV = v;
        starAnim = starAn;
    }

    @Override
    public void run() {
        synchronized (starAnim) {
            //critical section
            while (true) {
                try {
                    this.AV.postInvalidate();
                    Thread.sleep(50);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
