package main.java.archivio.java_collection_framework.library;

public class Book {
    private String title;

    Book(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
