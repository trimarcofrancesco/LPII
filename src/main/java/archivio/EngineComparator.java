package main.java.archivio;

/**
 * Con riferimento alla classe dell'esercizio 2, dire quali delle seguenti sono specifiche valide per un
 * Comparator tra due oggetti di tipo Engine, motivando la risposta. Nei casi non previsti dalle
 * speciche, il comparatore restituisce 0.
 * compare(a, b) restituisce:
 *
 * a) −1 se a ha cilindrata minore di b; 1 se a ha cilindrata maggiore di b
 * b) −1 se a ha potenza minore della metà di b; 1 se a ha potenza maggiore del doppio di b
 * c) −1 se a ha il rapporto potenza/cilindrata minore di b; 1 se a ha il rapporto potenza/cilindrata
 * maggiore di b
 * d) −1 se a ha cilindrata oppure potenza minore di b; 1 se a ha sia cilindrata sia potenza
 * maggiori di b
 * e) −1 se a ha cilindrata 1200 e potenza minore di b; 1 se a ha cilindrata 1200 e potenza
 * maggiore di b
 */
public class EngineComparator {
    /*

        Riflessività, x.compareTo(x) == 0

        Antisimmetria,
        x.compareTo(y) < 0 se e solo se y.compareTo(x) > 0
        x.compareTo(y) == 0 se e solo se y.compareTo(x) == 0

        Transitività,
        x.compareTo(y) < 0 e y.compareTo(z) < 0 allora x.compareTo(z) < 0



        a) −1 se a ha cilindrata minore di b; 1 se a ha cilindrata maggiore di b

            Rifl.       500.compareTo500 == 0                                                                               OK
            Antisimm.   500.compareTo(600) < 0 <=> 600.compareTo(500) > 0                                                   OK
            Trans.      500.compareTo(600) < 0 && 600.compareTo(700) < 0 => 500.compareTo(700) < 0                          OK

        b) −1 se a ha potenza minore della metà di b; 1 se a ha potenza maggiore del doppio di b

            Rifl.       500.compareTo(500) == 0                                                                             OK
            Antisimm.   200.compareTo(500) < 0 <=> 500.compareTo(200) > 0                                                   OK
            Trans.      100.compareTo(300) < 0 && 300.compareTo(700) < 0 => 100.compareTo(700) < 0                          OK

        c) −1 se a ha il rapporto potenza/cilindrata minore di b; 1 se a ha il rapporto potenza/cilindrata maggiore di b

            Rifl.       {2,4}.compareTo({2,4}) == 0                                                                         OK
            Antisimm.   {2,4}.compareTo({2,2}) < 0 <=> {2,2}.compareTo({2,4}) > 0                                           OK
            Trans.      {1,1}.compareTo({1,2}) < 0 && {1,2}.compareTo({3,1}) < 0 => {1,1}.compareTo({3,1}) < 0              OK

        d) −1 se a ha cilindrata oppure potenza minore di b; 1 se a ha sia cilindrata sia potenza maggiori di b

            Rifl.       {1,2}.compareTo({1,2}) == 0                                                                         OK
            Antisimm.   {1,2}.compareTo({2,1}) < 0 <=> {2,1}.compareTo({1,2}) > 0                                           NO

        e) −1 se a ha cilindrata 1200 e potenza minore di b; 1 se a ha cilindrata 1200 e potenza maggiore di b

            Rifl.       {1200,4}.compareTo({1200,4}) == 0                                                                           OK
            Antisimm.   {1200,2}.compareTo({2,3000}) < 0 <=> {2,3000}.compareTo({1200,2}) > 0                                       NO

     */
}
