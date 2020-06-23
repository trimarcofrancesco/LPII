package main.java.archivio.scelta_firma;

/**
 *  Il metodo statico arePermutations, accetta due liste e controlla se contengono gli stessi elementi
 *  (secondo equals), anche in ordine diverso.
 *  Valutare ciascuna delle seguenti intestazioni in base ai criteri di funzionalità, completezza, correttezza, fornitura di ulteriori garanzie e semplicità. Scegliere l'intestazione migliore oppure
 *  proporne un'altra. Infine, implementare il metodo usando l'intestazione prescelta.
 */

import java.util.*;

/**
 *  a) boolean arePermutations(List<?> a, List<?> b)
 *  b) <S,T> boolean arePermutations(List<S> a, List<T> b)
 *  c) <S> boolean arePermutations(List<S> a, List<S> b)
 *  d) <S> boolean arePermutations(List<? extends S> a, List<? extends S> b)
 *  e) boolean arePermutations(List<Object> a, List<Object> b)
 *  f) <S, T extends S> boolean arePermutations(List<? extends S> a, List<? extends T> b)
 */

public class Permutations {
    // Completa (accetta tutto quello richiesto dalla pre-condizione
    // Corretta (esclude elementi non previsti dalla pre-condizione)
    // Funzionale
    // Ulteriori garanzie (No scritture/letture)
    boolean arePermutations1(List<?> a, List<?> b) {
        if (a.size() != b.size()) return false;

        boolean result = true;
        for(Object el: a) {
            if (!b.contains(el)) {
                result = false;
                break;
            }
        }
        for(Object el: b) {
            if (!a.contains(el)) {
                result = false;
                break;
            }
        }

        return result;
    }

    // Completa
    // Corretta
    // Funzionale
    // 2 parametri di tipo
    <S,T> boolean arePermutations2(List<S> a, List<T> b) {
        if (a.size() != b.size()) return false;

        boolean result = true;
        for(S el: a) {
            if (!b.contains(el)) {
                result = false;
                break;
            }
        }
        for(T el: b) {
            if (!a.contains(el)) {
                result = false;
                break;
            }
        }
        return result;
    }

    // Non completa (posso passare solo parametri dello stesso tipo) // ATTENZIONE E' COMPLETA PERCHE' OBJECT E' SUPERCLASSE DI TUTTI I TIPI
    // Corretta
    // Funzionale
    // 1 parametro di tipo
    // No ulteriori garanzie
    <S> boolean arePermutations3(List<S> a, List<S> b) {
        return false;
    }

    // Non completa (non accetta liste non confrontabili)
    // Corretta
    // Funzionale
    // 1 parametro di tipo
    // Ulteriori garanzie
    <S> boolean arePermutations4(List<? extends S> a, List<? extends S> b) {
        return false;
    }

    // Non completa
    // Corretta
    // Funzionale
    // No garanzie
    boolean arePermutations5(List<Object> a, List<Object> b) {
        return false;
    }

    // Completa (posso passare solo stesso tipo o b sottotipo di a)
    // Corretta
    // Funzionale
    // 2 parametri di tipo
    // Ulteriori garanzie
    <S, T extends S> boolean arePermutations6(List<? extends S> a, List<? extends T> b) {
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1,1,2,3));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(2,1,1,3));

        Permutations p = new Permutations();
        System.out.println(p.arePermutations1(list1, list2));
    }
}
