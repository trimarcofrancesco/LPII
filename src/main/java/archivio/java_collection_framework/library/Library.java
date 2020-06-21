package main.java.archivio.java_collection_framework.library;

import java.util.*;

public class Library {

    private Set<Book> archive = new HashSet<>();
    private Set<Book> loans = new HashSet<>();

    Library() { }

    public boolean addBook(Book book) {
        return archive.add(book);
    }

    public boolean loanBook(Book book) {
        if (!archive.contains(book))
            throw new IllegalArgumentException();

        return archive.remove(book) && loans.add(book);
    }

    public void returnBook(Book book) {
        if (!loans.contains(book))
            throw new IllegalArgumentException();

        loans.remove(book);
        addBook(book);
    }

    public void printLoans() {
        List<Book> loansList = new ArrayList<>(loans);
        Collections.reverse(loansList);
        Iterator<Book> iterator = loansList.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getTitle());
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        Book a = new Book("a"), b = new Book("b"), c = new Book("c");
        System.out.println(lib.addBook(a));
        System.out.println(lib.addBook(b));
        System.out.println(lib.addBook(c));
        System.out.println(lib.addBook(a));
        System.out.println(lib.loanBook(b));
        System.out.println(lib.loanBook(a));
        lib.printLoans();
    }
}
