package main.java.archivio.multithread;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

Realizzare la classe thread-safe Market, che permette a diversi thread di contrattare il prezzo
di un servizio.

Il metodo sell offre il servizio per un certo prezzo e blocca il chiamante finché
non arriverà una richiesta con un importo adeguato.

Simmetricamente, il metodo buy richiede il
servizio per un certo prezzo e blocca il chiamante finché non arriverà un'offerta adeguata.
Per semplicità, si può supporre che tutti gli importi passati a sell e buy siano diversi.

Thread 1: m.buy(10.0);      resta bloccato
Thread 2: m.sell(15.50);    resta bloccato
Thread 3: m.sell(12.0);     resta bloccato
Thread 4: m.buy(13.0);      sblocca T3 e ritorna
Thread 5: m.buy(11.0);      resta bloccato
Thread 6: m.sell(9.50);     sblocca T1 oppure T5 e ritorna

 */


public class Market {
    private final SortedSet<Double> enquiry = new TreeSet<>();
    private final SortedSet<Double> offers = new TreeSet<>();

    public Market() {}

    public synchronized void buy(Double price) throws InterruptedException {
        enquiry.add(price);
        notifyAll();

        if (!offers.isEmpty()) {
            while (offers.first() > price) {
                wait();
            }
        }
        System.out.println("Comprato a: " + price);
    }

    public synchronized void sell(Double price) throws InterruptedException {
        offers.add(price);
        notifyAll();

        if (!enquiry.isEmpty()) {
            while (enquiry.last() < price) {
                wait();
            }
        }
        System.out.println("Comprato a: " + price);
        enquiry.remove(enquiry.last());
        offers.remove(price);
    }

    public static void main(String[] args) throws InterruptedException {
        Market m = new Market();
        int i = 0;
        Thread[] t = new Thread [6];
        t[i] = new Thread () {
            @Override
            public void run() {
                try {
                    m.buy(10.0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        t[i].start();
        i++;
        t[i] = new Thread() {
            @Override
            public void run() {
                try {
                    m.sell(15.50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t[i].start();
        i++;
        t[i] = new Thread() {
            @Override
            public void run() {
                try {
                    m.sell(12.0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        t[i].start();
        i++;
        t[i] = new Thread() {
            @Override
            public void run() {
                try {
                    m.buy(13.0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t[i].start();
        i++;
        t[i] = new Thread() {
            @Override
            public void run() {
                try {
                    m.buy(11.0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        t[i].start();
        i++;
        t[i] = new Thread() {
            @Override
            public void run() {
                try {
                    m.sell(9.5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t[i].start();
        // m.buy(13.0);
        // m.buy(11.0);
        // m.sell (9.50) ;
    }


}




/*

public class Market {

    BlockingQueue<Double> sells = new LinkedBlockingQueue<>();
    BlockingQueue<Double> buys = new LinkedBlockingQueue<>();

    public void sell(Double price) {
        Thread thread = new Thread(() -> {
            String threadId = "Sell-" + Thread.currentThread().getId();
            try {
                sells.put(price);

                Double buyPrice;
                while(!buys.isEmpty()) {
                    if ((buyPrice = buys.take()) < price)
                        buys.add(buyPrice);
                    else {
                        System.out.println("Venduto a: " + price);
                    }
                }
                System.out.println(threadId + " STOPPED.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void buy(Double price) {
        Thread thread = new Thread(() -> {
            String threadId = "Buy-" + Thread.currentThread().getId();
            try {
                buys.put(price);

                Double sellPrice;
                while(!sells.isEmpty()) {
                    if ((sellPrice = sells.take()) > price)
                        sells.add(sellPrice);
                    else {
                        System.out.println("Comprato a: " + price);
                    }
                }
                System.out.println(threadId + " STOPPED.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public static void main(String[] args) {
        Market m = new Market();

        m.buy(10.0);
        m.sell(15.50);
        m.sell(12.0);
        m.buy(13.0);
        m.buy(11.0);
        m.sell(9.50);
    }

}

*/
