package main.java.archivio.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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

    BlockingQueue<Double> sells = new ArrayBlockingQueue<>(10);
    BlockingQueue<Double> buys = new ArrayBlockingQueue<>(10);

    public void sell(Double price) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10);
                sells.put(price);
                //System.out.println("Sell: produced "+ price.toString());

                Double buyPrice;
                while(!buys.isEmpty()) {
                    if ((buyPrice = buys.take()) < price)
                        sells.add(buyPrice);
                    else {
                        Thread.sleep(10);
                        System.out.println("Buy: consumed " + buyPrice.toString());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void buy(Double price) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10);
                buys.put(price);
                //System.out.println("Buy: produced "+ price.toString());

                Double sellPrice;
                while(!sells.isEmpty()) {
                    if ((sellPrice = sells.take()) > price)
                        sells.add(sellPrice);
                    else {
                        Thread.sleep(10);
                        System.out.println("Sell: consumed " + sellPrice.toString());
                    }
                }

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
