package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concurrent {

    public interface Predicate<T> {
        boolean test(T x);
    }

    static <T> Set<T> concurrentFilter(Set<? extends T> x, Predicate<T> p) {
        List<Thread> threads = new ArrayList<>();
        Set<T> y = new HashSet<>(); // HashSet, così come la maggior parte delle collezioni standard, non è thread safe, dobbiamo prenderci in carico la mutua esclusione

        class MyThread extends Thread {
            private T el;
            private Predicate<T> p;
            private final Set<T> y;

            MyThread(T el, Predicate<T> p, Set<T> y) {
                this.el = el;
                this.p = p;
                this.y = y;
            }

            @Override
            public void run() {
                if (p.test(el)) {
                    synchronized (y) { // Senza synchronized, se due thread provassero a modificare y, potrebbe anche crashare il programma (accesso concorrente)
                        y.add(el);
                    }
                }
            }
        }

        for (T el: x) {
            Thread t = new MyThread(el, p, y);
            threads.add(t);
            t.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return y;
    }

    public static void main(String[] args) {
        Set<Integer> x = new HashSet<Integer>();
        x.add(1); x.add(2); x.add(5);

        Predicate<Integer> isOdd = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return (n%2 != 0);
            }
        };

        Set<Integer> y = concurrentFilter(x, isOdd);
        for (Integer n: y)
            System.out.println(n);
    }

}