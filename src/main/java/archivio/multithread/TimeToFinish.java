package main.java.archivio.multithread;

import javafx.util.Pair;

import java.util.*;

/**
 * Implementare la classe thread-safe TimeToFinish, che permette a diversi thread di comunicare
 * quanto tempo manca alla propria terminazione.
 * Il metodo setEstimate accetta un long che rappresenta il numero di millisecondi che mancano al thread chiamante per terminare la sua esecuzione
 * (cioè, il time-to-finish). Il metodo maxTimeToFinish restituisce in tempo costante il numero di
 * millisecondi necessari perché tutti i thread terminino. La stringa restituita da toString riporta il
 * time-to-finish di tutti i thread.
 * Suggerimento: il metodo statico System.currentTimeMillis() restituisce un long che rappresenta il
 * numero di millisecondi trascorsi dal 1 gennaio 1970 (POSIX time).
 */

public class TimeToFinish {

    private final SortedSet<Pair<Thread, Long>> threads = new TreeSet<>(Comparator.comparing(Pair::getValue));

    public synchronized void setEstimate(long ms) {
        threads.add(new Pair<>(Thread.currentThread(), System.currentTimeMillis()+ms));

        try {
            wait(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long maxTimeToFinish() {
        long maxTime = 0;
        for (Pair<Thread,Long> o: threads) {
            maxTime += o.getValue() - System.currentTimeMillis();
        }
        return maxTime;
    }

    @Override
    public String toString() {
        String format = "";

        for (Pair<Thread, Long> o : threads) {
            format += o.getKey().getName() + ": " + (o.getValue() - System.currentTimeMillis()) + "\n";
        }

        return format;
    }

    public static void main(String[] args) throws InterruptedException {
        TimeToFinish ttf = new TimeToFinish();
        ttf.setEstimate(5000);

        Thread thread1 = new Thread(() -> {
            ttf.setEstimate(3000);
        });
        thread1.start();
        // a questo punto un altro thread invoca ttf.setEstimate(3000)
        Thread.sleep(500);
        System.out.println("Tempo rimanente: " + ttf.maxTimeToFinish() + " millisecondi.");
        System.out.println(ttf);

        // Output atteso

        // Tempo rimanente: 4500 millisecondi
        // Thread 1: 2500
        // Thread main: 4500
    }
}
