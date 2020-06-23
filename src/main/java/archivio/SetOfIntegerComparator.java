package main.java.archivio;

/**
 * Dire quali delle seguenti sono specifiche valide per un Comparator tra due oggetti di tipo Set<Integer>,
 * motivando la risposta. Nei casi non previsti dalle specifiche, il comparatore restituisce 0.
 * compare(a, b) restituisce:
 * a) −1 se a contiene un numero minore di tutti i numeri di b; 1 se b contiene un numero minore di tutti i numeri di a
 * b) −1 se la somma dei numeri di a è minore della somma dei numeri di b; 1 se la media dei numeri di b è maggiore della media dei numeri di a
 * c) −1 se a contiene tutti numeri negativi e b no; 1 se b contiene tutti numeri positivi e a no
 * d) −1 se a contiene il numero 0; 1 se a non contiene il numero 0
 * e) −1 se a contiene il numero 0 e b no; 1 se b contiene il numero 0 e a no
 *
 */
public class SetOfIntegerComparator {
    /*

        Riflessività, x.compareTo(x) == 0

        Antisimmetria,
        x.compareTo(y) < 0 se e solo se y.compareTo(x) > 0
        x.compareTo(y) == 0 se e solo se y.compareTo(x) == 0

        Transitività,
        x.compareTo(y) < 0 e y.compareTo(z) < 0 allora x.compareTo(z) < 0



        a) −1 se a contiene un numero minore di tutti i numeri di b; 1 se b contiene un numero minore

            Rifl.       {0,1,2}.compareTo({0,1,2}) == 0                                                                     OK
            Antisimm.   {0,1,2}.compareTo({1,2}) < 0 <=> {1,2}.compareTo({0,1,2}) > 0                                       OK
            Trans.      {0,1,2}.compareTo({1,2}) < 0 && {1,2}.compareTo({2}) < 0 => {0,1,2}.compareTo({2}) < 0              OK

        b) −1 se la somma dei numeri di a è minore della somma dei numeri di b; 1 se la media dei numeri di b è maggiore della media dei numeri di a

            Rifl.       {0,1,2}.compareTo({0,1,2}) == 0                                                                     OK
            Antisimm.   {-1,1}.compareTo({1,2}) < 0 <=> {1,2}.compareTo({-1,1}) > 0                                         OK
            Trans.      {-1,3}.compareTo({1,2}) < 0 && {1,2}.compareTo({4}) < 0 => {-1,3}.compareTo({4}) < 0                OK

        c) −1 se a contiene tutti numeri negativi e b no; 1 se b contiene tutti numeri positivi e a no

            Rifl.       {-1,-1}.compareTo({-1,-1}) == 0                                                                     OK
            Antisimm.   {-1,-1}.compareTo({1,-2}) < 0 <=> {1,-2}.compareTo({-1,-1}) > 0                                     NO

        d) −1 se a contiene il numero 0; 1 se a non contiene il numero 0

            Rifl.       {0}.compareTo({0}) == 0                                                                             NO


        e) −1 se a contiene il numero 0 e b no; 1 se b contiene il numero 0 e a no

            Rifl.       {0}.compareTo({0}) == 0                                                                             NO

     */
}
