package main.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExecuteInParallelExercise {

    static void executeInParallel(final Runnable[] runnables, final int k) throws InterruptedException {
        if (k < 0) throw new IllegalArgumentException();

        final BlockingQueue<Thread> buffer = new ArrayBlockingQueue<>(k);

        for (Runnable r: runnables) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    r.run();
                    buffer.remove(this);
                }
            };
            buffer.put(t);
            t.start();
        }


        /*

        new Thread(
                () -> {
                    for (Runnable runnable: runnables) {
                        try {
                            buffer.put(runnable);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        new Thread(
                () -> {
                    while (!buffer.isEmpty()) {
                        try {
                            Runnable runnable = buffer.take();
                            new Thread(runnable).start();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

         */
    }

    public static void main(String[] args) {
        Runnable r1 = () -> {System.out.print("1");};
        Runnable r2 = () -> {System.out.print("2");};
        Runnable r3 = () -> {System.out.print("3");};
        Runnable r4 = () -> {System.out.print("4");};
        Runnable r5 = () -> {System.out.print("5");};
        Runnable r6 = () -> {System.out.print("6");};
        Runnable r7 = () -> {System.out.print("7");};
        Runnable r8 = () -> {System.out.print("8");};

        Runnable[] array = new Runnable[]{r1,r2,r3,r4,r5,r6,r7,r8};
        try {
            executeInParallel(array,2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
