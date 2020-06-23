package main.java.archivio;

/**
 * Un employee è caratterizzato da nome (stringa) e salario (intero non negativo). Dire quali delle
 * seguenti sono speciche valide per un Comparator tra employee. In caso negativo, motivare la
 * risposta con un controesempio. Nei casi non previsti dalle speciche, il comparatore restituisce
 * 0.
 * compare(x,y) restituisce:
 *
 * a) -1 se il nome di x è uguale a quello di y, ma i salari sono diversi; 1 se il salario di x è uguale
 * a quello di y, ma i nomi sono diversi.
 * b) -1 se il salario di x è zero e quello di y è maggiore di zero; 1 se il salario di y è zero e quello
 * di x è maggiore di zero.
 * c) -1 se il salario di x è maggiore di quello di y; 1 se il salario di x è minore di quello di y.
 * d) -1 se il nome di x precede alfabeticamente quello di y ed il salario di x è minore di quello di
 * y; 1 se il nome di y precede alfabeticamente quello di x.
 * e) -1 se il salario di x è minore di 2000 e quello di y è maggiore di 1000; 1 se il salario di y è
 * minore di 2000 e quello di x è maggiore di 1000.
 */

public class EmployeeComparator {
    /*

        Riflessività, x.compareTo(x) == 0

        Antisimmetria,
        x.compareTo(y) < 0 se e solo se y.compareTo(x) > 0
        x.compareTo(y) == 0 se e solo se y.compareTo(x) == 0

        Transitività,
        x.compareTo(y) < 0 e y.compareTo(z) < 0 allora x.compareTo(z) < 0

        a) -1 se il nome di x è uguale a quello di y, ma i salari sono diversi; 1 se il salario di x è uguale a quello di y, ma i nomi sono diversi.

            Rifl.       ("Ciccio", 1000).compareTo("Ciccio", 1000) == 0                                                                                                                 OK
            Antisimm.   ("Ciccio", 1000).compareTo("Ciccio", 1200) < 0 <=> ("Ciccio", 1200).compareTo("Ciccio", 1000) > 0                                                               NO

        b) -1 se il salario di x è zero e quello di y è maggiore di zero; 1 se il salario di y è zero e quello di x è maggiore di zero.

            Rifl.       ("Ciccio", 0).compareTo("Ciccio", 0) == 0                                                                                                       OK
            Antisimm.   ("Ciccio", 0).compareTo("Ciccio", 1000) < 0 <=> ("Ciccio", 1000).compareTo("Ciccio", 0) > 0                                                     OK
            Trans.      ("Ciccio", 0).compareTo("Ciccio", 100) < 0 && ("Ciccio", 100).compareTo("Genny", 200) < 0 => ("Ciccio", 0).compareTo(200) < 0                   OK

        c) -1 se il salario di x è maggiore di quello di y; 1 se il salario di x è minore di quello di y.

            Rifl.       ("Ciccio", 100).compareTo("Ciccio", 100) == 0                                                                                                   OK
            Antisimm.   ("Ciccio", 100).compareTo("Ciccio", 0) < 0 <=> ("Ciccio", 0).compareTo("Ciccio", 100) > 0                                                       OK
            Trans.      ("Ciccio", 100).compareTo("Ciccio", 50) < 0 && ("Ciccio", 90).compareTo("Ciccio", 80) < 0 => ("Ciccio", 100).compareTo("Ciccio", 80) < 0        OK

        d) -1 se il nome di x precede alfabeticamente quello di y ed il salario di x è minore di quello di y; 1 se il nome di y precede alfabeticamente quello di x.

            Rifl.       ("Ciccio", 100).compareTo("Ciccio", 100) == 0                                                                                                   OK
            Antisimm.   ("Ciccio", 100).compareTo("Demetrio", 200) < 0 <=> ("Demetrio", 200).compareTo("Ciccio", 100) > 0                                               NO

        e) -1 se il salario di x è minore di 2000 e quello di y è maggiore di 1000; 1 se il salario di y è minore di 2000 e quello di x è maggiore di 1000.

            Rifl.       ("Ciccio", 100).compareTo("Ciccio", 100) == 0                                                                                                   OK
            Antisimm.   ("Ciccio", 100).compareTo("Ciccio", 1999) < 0 <=> ("Ciccio", 1999).compareTo("Ciccio", 100) > 0                                                 NO

     */
}
