package main.java.archivio.java_collection_framework.merge;

import java.util.LinkedList;

public class Merge {
    /*

    Realizzare un metodo chiamato merge che rispetti il seguente contratto:

    Pre-condizione Accetta due LinkedList dello stesso tipo e di pari lunghezza.

    Post-condizione Restituisce una nuova LinkedList ottenuta alternando gli elementi della prima
    lista e quelli della seconda.

    Ad esempio, se la prima lista contiene (1, 2, 3) e la seconda lista (4, 5, 6), la nuova lista deve
    contenere (1, 4, 2, 5, 3, 6).

    Penale Se le liste non hanno la stessa lunghezza, lancia IllegalArgumentException.

    */

    public <T> LinkedList<T> merge(LinkedList<T> list1, LinkedList<T> list2) {
        // Come ottenere la correttezza attraverso la firma? Java non prevede un tipo lista con lunghezza prefissata, per cui è impossibile
        // Verifico la lunghezza a tempo di esecuzione, se sono diverse, lancio un eccezione
        if (list1.size() != list2.size())
            throw new IllegalArgumentException("Length must be same!");

        LinkedList<T> merged = new LinkedList<>();

        for (int i=0; i<list1.size(); i++) { // or list2, is the same
            merged.add(list1.get(i));
            merged.add(list2.get(i));
        }

        return merged;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);
        //l2.add(7); // throw an exception

        for (Integer i: new Merge().merge(l1, l2)) {
            System.out.println(i);
        }
    }
}
