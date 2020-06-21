package main.java;

import java.util.Collections;
import java.util.HashSet;

/**
 * Si implementi la classe main.java.Container, che rappresenta un contenitore per liquidi di dimensione fissata.
 * Ad un contenitore, inizialmente vuoto, si può aggiungere acqua con il metodo addWater, che prende
 * come argomento il numero di litri.
 * Il metodo getAmount restituisce la quantità d'acqua presente nel contenitore.
 * Il metodo connect prende come argomento un altro contenitore, e lo collega a questo con un tubo.
 * Dopo il collegamento, la quantità d'acqua nei due contenitori (e in tutti quelli ad essi collegati) sarà la
 * stessa.
 */

public class Container {

    private double amount = 0;
    private HashSet<Container> connectedContainers = new HashSet<>(Collections.singleton(this));

    public void addWater(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount of water cannot be a negative value");

        this.amount += amount;
    }

    public double getAmount() {
        return amount;
    }

    public void connect(Container otherContainer) {
        if (otherContainer == null)
            throw new IllegalArgumentException("Other container cannot be null");

        connectedContainers.addAll(otherContainer.connectedContainers);

        double totalOfWater = 0;

        for (Container container: connectedContainers) {
            container.connectedContainers = connectedContainers;
            totalOfWater += container.getAmount();
        }

        for (Container connectedContainer: connectedContainers) {
            connectedContainer.amount = totalOfWater / (connectedContainers.size());
        }
    }

    public static void main(String[] args) {
        Container a = new Container(), b = new Container(), c = new Container(), d = new Container();

        a.addWater(12);
        d.addWater(8);

        a.connect(b);
        System.out.println(a.getAmount()+" "+b.getAmount()+" "+c.getAmount()+" "+d.getAmount());
        b.connect(c);
        System.out.println(a.getAmount()+" "+b.getAmount()+" "+c.getAmount()+" "+d.getAmount());
        c.connect(d);
        System.out.println(a.getAmount()+" "+b.getAmount()+" "+c.getAmount()+" "+d.getAmount());
    }
}
