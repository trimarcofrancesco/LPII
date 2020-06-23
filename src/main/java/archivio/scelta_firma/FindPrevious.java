package main.java.archivio.scelta_firma;

/*

    Implementare il metodo statico findPrevious, che accetta un insieme, un comparatore e un oggetto x,
    e restituisce il più grande oggetto dell'insieme che è minore di x (secondo il comparatore).
    Se tale oggetto non esiste (perché tutti gli elementi dell'insieme sono maggiori o uguali a x), il metodo restituisce null.
    Valutare ciascuna delle seguenti intestazioni in base ai criteri di funzionalità, completezza, correttezza,
    fornitura di ulteriori garanzie, semplicità e specicità del tipo di ritorno.
    Infine, scegliere l'intestazione migliore oppure proporne un'altra.


    a) <T> T findPrevious(Set<? extends T> set, Comparator<?> comp, T x)
    b) <S,T extends S> T findPrevious(Set<T> set, Comparator<S> comp, T x)
    c) <S,T extends S> S findPrevious(Set<S> set, Comparator<T> comp, S x)
    d) <T> T findPrevious(Set<T> set, Comparator<? super T> comp, T x)
    e) <T> T findPrevious(Set<T> set, Comparator<T> comp, T x)
    f) <T> T findPrevious(Set<? super T> set, Comparator<T> comp, T x)

*/

import main.java.model.Employee;
import main.java.model.Manager;

import java.util.*;

public class FindPrevious {

    /**
     * Completa, corretta, non funzionale (impossibilità di usare Comparator col jolly)
     */
    //<T> T findPrevious(Set<? extends T> set, Comparator<?> comp, T x) {
    //    if (set.isEmpty())
    //        return null;
    //
    //    Iterator<? extends T> iterator = set.iterator();
    //    T previous = null;
    //
    //    while (iterator.hasNext()) {
    //        if (comp.compare(iterator.next(), x) < 0) {
    //
    //        }
    //    }
    //
    //    return null;
    //}

    /**
     * Non completa (scarta i sottotipi di T), corretta, funzionale, usa due parametri di tipo
     */
    //<S,T extends S> T findPrevious(Set<T> set, Comparator<S> comp, T x) {
    //    if (set.isEmpty())
    //        return null;
    //
    //    Iterator<T> iterator = set.iterator();
    //    T previous = null;
    //    T current;
    //
    //    while (iterator.hasNext()) {
    //        if (comp.compare((current = iterator.next()), x) < 0) {
    //            if (previous == null || comp.compare(previous, current) >= 0)
    //                previous = current;
    //        }
    //    }
    //
    //    return previous;
    //}

    /**
     * Non completa (scarta i sottotipi di S), corretta, funzionale, usa due parametri di tipo
     */
    //<S,T extends S> S findPrevious(Set<S> set, Comparator<T> comp, S x) {
    //    if (set.isEmpty())
    //        return null;
    //    Iterator<T> iterator = (Iterator<T>) set.iterator();
    //    T previous = null;
    //    T current;
    //    while (iterator.hasNext()) {
    //        if (comp.compare((current = iterator.next()), (T) x) < 0) {
    //            if (previous == null || comp.compare(previous, current) >= 0)
    //                previous = current;
    //        }
    //    }
    //    return previous;
    //}

    /**
     *
     */
    //<T> T findPrevious(Set<T> set, Comparator<? super T> comp, T x) {
    //    if (set.isEmpty())
    //        return null;
    //    Iterator<T> iterator = set.iterator();
    //    T previous = null;
    //    T current;
    //    while (iterator.hasNext()) {
    //        if (comp.compare((current = iterator.next()), x) < 0) {
    //            if (previous == null || comp.compare(previous, current) >= 0)
    //                previous = current;
    //        }
    //    }
    //    return previous;
    //}

    //<T> T findPrevious(Set<T> set, Comparator<T> comp, T x) {
    //
    //}

    /**
     *  Non completa (non accetta set Manager e Employee come oggetto), corretta, funzionale, 1 parametro di tipo
     */
    //<T> T findPrevious(Set<? super T> set, Comparator<T> comp, T x) {
    //    if (set.isEmpty())
    //        return null;
    //    Iterator<? super T> iterator = set.iterator();
    //    T previous = null;
    //    T current;
    //    while (iterator.hasNext()) {
    //        if (comp.compare((current = (T) iterator.next()), x) < 0) {
    //            if (previous == null || comp.compare(previous, current) >= 0)
    //                previous = current;
    //        }
    //    }
    //    return previous;
    //}

    <T,S extends T> T findPrevious(Set<? extends T> set, Comparator<? super T> comp, S x) {
        if (set.isEmpty())
            return null;
        Iterator<T> iterator = (Iterator<T>) set.iterator();
        T previous = null;
        T current;
        while (iterator.hasNext()) {
            if (comp.compare((current = iterator.next()), x) < 0) {
                if (previous == null || comp.compare(previous, current) >= 0)
                    previous = current;
            }
        }
        return previous;
    }

    public static void main(String[] args) {
        Set<Integer> setOfInteger = new HashSet<>(Arrays.asList(11, 7, 8, 10));

        Employee employee = new Employee("Elia Pasticcio", 2000);
        Manager manager1 = new Manager("Ciccio Pasticcio", 2000);
        Manager manager2 = new Manager("Demetrio Pasticcio", 2000);
        Manager manager3 = new Manager("Francesco Pasticcio", 2000);
        Set<Manager> setOfManager = new HashSet<>(Arrays.asList(manager1, manager2, manager3));
        Set<Employee> setOfEmployee = new HashSet<>(Arrays.asList(employee));


        FindPrevious f = new FindPrevious();
        System.out.println(f.findPrevious(setOfInteger, Integer::compareTo, 8));

        System.out.println(f.findPrevious(setOfManager, Employee.comparatorByName, employee).toString());
        System.out.println(f.findPrevious(setOfEmployee, Employee.comparatorByName, manager3).toString());
    }

}
