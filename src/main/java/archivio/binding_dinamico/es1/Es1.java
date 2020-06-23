package main.java.archivio.binding_dinamico.es1;

/*

• Per ogni chiamata ad un metodo (escluso System.out.println) indicare la lista delle rme
candidate.

• Indicare l'output del programma. Se un'istruzione provoca un errore di compilazione,
specicarlo e poi continuare l'esercizio ignorando quell'istruzione.

 */

public class Es1 {

    public static void main(String[] args) {
        B[] arrayB = new B[10];
        A[] arrayA = arrayB;
        arrayB[0] = new B();

        System.out.println(arrayA[0].f(arrayA[0], null)); // B2
    }

    /*

    arrayB[0].f(null, arrayB) -> { // Il tipo dichiarato di arrayB[0] è B <- Il tipo dichiarato di arrayB è B[], quello attuale B[]
        In B:
        1) public String f(B x, B[] y) { return "B1"; } OK nel late binding // B1
        2) public String f(A x, A[] y) { return "B2"; }
        3) public String f(A x, Object[] y) { return "B3"; }

        In A:
        4) public String f(A x, A[] y) { return "A1"; }
        5) public String f(A x, Object y) { return "A2:" + x.f(new B(), null); }
    }

    arrayA[0].f(null, arrayA) -> { // Il tipo dichiarato di arrayA[0] è A <- Il tipo dichiarato di arrayA è A[], quello attuale B[]
        In B:
        1) public String f(A x, A[] y) { return "B2"; } In overriding OK nel late binding // B2

        In A:
        1) public String f(A x, A[] y) { return "A1"; }
        2) public String f(A x, Object y) { return "A2:" + x.f(new B(), null); }

    }

    arrayA[0].f(arrayA[0], null) -> { // Il tipo dichiarato di arrayA[0] è A <- Il tipo dichiarato di arrayA[0] è A, quello attuale B[]
        In B:
        1) public String f(A x, A[] y) { return "B2"; } In overriding OK nel late binding // B2

        In A:
        1) public String f(A x, A[] y) { return "A1"; }
        2) public String f(A x, Object y) { return "A2:" + x.f(new B(), null); }
    }

    x.f(new B(), null) -> { // Il tipo dichiarato di x è A <- Il tipo attuale del primo parametro è B
        In A:
        1) public String f(A x, A[] y) { return "A1"; }
        2) public String f(A x, Object y) { return "A2:" + x.f(new B(), null); } OK nel late binding // Loop?
    }

     */

}
