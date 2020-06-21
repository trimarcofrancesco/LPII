package main.java.archivio.java_collection_framework.cellphone;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Cellphone {
    private final String gestore;
    private final String numero;
    private static Map<Pair<String, String>, Double> costs = new HashMap<>();

    Cellphone(String gestore, String numero) {
        this.gestore = gestore;
        this.numero = numero;
    }

    public static void setCost(String gestore1, String gestore2, double costo) {
        costs.put(new Pair<>(gestore1, gestore2), costo);
    }

    public double getCost(Cellphone other, int minutes) {
        Pair<String, String> key = new Pair<>(gestore, other.gestore);

        if (!Cellphone.costs.containsKey(key))
            throw new IllegalArgumentException();

        double cost = Cellphone.costs.get(new Pair<>(gestore, other.gestore));
        return cost * minutes;
    }

    public static void main(String[] args) {
        Cellphone a = new Cellphone("TIMMY", "3341234"),
                b = new Cellphone("Megafon", "3355678"),
                c = new Cellphone("Odissey", "3384343");
        Cellphone.setCost("TIMMY", "TIMMY", 0.05);
        Cellphone.setCost("TIMMY", "Megafon", 0.15);
        Cellphone.setCost("Megafon", "TIMMY", 0.25);
        System.out.println(a.getCost(b, 10));
        System.out.println(b.getCost(a, 8));
        System.out.println(a.getCost(c, 10)); // provoca eccezione
    }
}
