package main.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Implementare il metodo subMap che accetta una mappa e una collezione e restituisce una nuova mappa
    ottenuta restringendo la prima alle sole chiavi che compaiono nella collezione.
    Il metodo non modifica i suoi argomenti
 */
public class SubMap {

    /*

        PRECOND:    deve valere una relazione tra il tipo della mappa e il tipo della collezione?
                    No, da contratto potrebbero essere completamente scollegate Map e Collection

        POSTCOND:


     */



    // a)
    // è funzionale, corretta ma non completa
    // Non completa perchè richiede che le chiavi e la collezione siano dello stesso tipo
    // preserva nel tipo di ritorno una parte dell'informazione di tipo presente nel primo argomento
    // non esprime la garanzia che il secondo argomento non verrà né letto né scritto
    // usa un solo parametro di tipo

    /*<K> Map<K,?> subMap(Map<K,?> m, Collection<K> c) {
        Map<K,Object> outMap = new HashMap<>();

        for (Object key: c) {
            if (m.containsKey(key))
                outMap.put((K) key, m.get(key));
        }

        return outMap;
    }*/

    // ----------------------------------------------------------------------------

    // b)
    // è funzionale, corretta e completa
    // preserva nel tipo di ritorno l'informazione di tipo presente nel primo argomento
    // esprime la garanzia che il secondo argomento non verrà né letto né scritto
    // usa due parametri di tipo

    // MIGLIORAMENTO subMap(Map<? extends K,? extends V> m, Collection<?> c) per dare ulteriori garanzie che non vengano fatte scritture sulla mappa

    <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c) {
        Map<K,V> outMap = new HashMap<>();

        for (Object key: c) {
            if (m.containsKey(key))
                outMap.put((K) key, m.get(key));
        }

        return outMap;
    }

    // ----------------------------------------------------------------------------

    // c)
    // è funzionale, corretta e non completa (non prende sottotipi di K)
    // preserva nel tipo di ritorno l'informazione di tipo presente nel primo argomento
    // non esprime la garanzia che il secondo argomento non verrà né letto né scritto
    // usa due parametri di tipo

    /*<K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c) {
        Map<K,V> outMap = new HashMap<>();

        for (Object key: c) {
            if (m.containsKey(key))
                outMap.put((K) key, m.get(key));
        }

        return outMap;
    }*/

    // ----------------------------------------------------------------------------

    // d)
    // è funzionale, corretta e non completa (non prende supertipi di K)
    // preserva nel tipo di ritorno l'informazione di tipo presente nel primo argomento
    // esprime la garanzia che il secondo argomento non verrà scritto
    // usa due parametri di tipo

    /*<K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c) {
        Map<K,V> outMap = new HashMap<>();

        for (K key: c) {
            if (m.containsKey(key))
                outMap.put(key, m.get(key));
        }

        return outMap;
    }*/

    // ----------------------------------------------------------------------------

    // e)
    // è funzionale, corretta ma non completa (Set, e richiede che le chiavi e la collezione siano dello stesso tipo)
    // preserva nel tipo di ritorno l'informazione di tipo presente nel primo argomento
    // non esprime la garanzia che il secondo argomento non verrà né letto né scritto
    // usa due parametri di tipo

    /*<K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c) {
        Map<K,V> outMap = new HashMap<>();

        for (K key: c) {
            if (m.containsKey(key))
                outMap.put(key, m.get(key));
        }

        return outMap;
    }*/

    // ----------------------------------------------------------------------------

    // f)
    // è funzionale, corretta e non completa (richiede che le chiavi e la collezione siano dello stesso tipo, difficoltà in più inutile)
    // preserva nel tipo di ritorno l'informazione di tipo presente nel primo argomento
    // non esprime la garanzia che il secondo argomento non verrà né letto né scritto
    // usa 3 parametri di tipo

    /*<K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c) {
        Map<K,V> outMap = new HashMap<>();

        for (K key: c) {
            if (m.containsKey(key))
                outMap.put(key, m.get(key));
        }

        return outMap;
    }*/

    // ----------------------------------------------------------------------------



    public static void main(String[] args) {


    }
}
