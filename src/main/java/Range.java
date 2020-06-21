package main.java;

/**
 * Realizzare la classe parametrica main.java.Range, che rappresenta un intervallo di oggetti dotati di ordinamento
 * naturale, con le seguenti funzionalità:
 * (a) Il costruttore accetta gli estremi dell'intervallo (l'oggetto minimo e l'oggetto massimo).
 * (b) Il metodo isInside accetta un oggetto x e restituisce true se e solo se x appartiene all'intervallo.
 * (c) Il metodo isOverlapping accetta un altro intervallo x e restituisce true se e solo se x è sovrapposto a
 * questo intervallo (cioè se i due hanno intersezione non vuota).
 * (d) Il metodo equals è ridefinito in modo che due intervalli con gli stessi estremi risultino uguali.
 * (e) Il metodo hashCode è ridefinito in modo da essere coerente con equals.
 */

public class Range<T extends Comparable<? super T>> {
    private final T min;
    private final T max;

    public Range(T min, T max) {
        if (min.compareTo(max) > 0)
            throw new IllegalArgumentException("Range non valido");

        this.min = min;
        this.max = max;
    }

    public boolean isInside(T x) {
        return x.compareTo(min) >= 0 && x.compareTo(max) <= 0;
    }

    // Troppo restrittiva, non completa!
    // Anche <? extends T> non è completa, ma è comunque meglio
    public boolean isOverlapping(Range<T> x) {
        return min.compareTo(x.max) <= 0 && x.min.compareTo(max) <= 0;
    }

    @Override
    public boolean equals(Object x) {
        if (!(x instanceof Range))
            return false;

        Range<?> range = (Range) x;

        return range.min.equals(min) && range.max.equals(max);
    }

    @Override
    public int hashCode() {
        return min.hashCode() ^ max.hashCode();
    }
}
