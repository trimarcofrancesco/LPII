package main.java;

import java.util.HashSet;
import java.util.Set;

public class SafeSet<T> {
    private Set<T> mSet = new HashSet<>();
    private Set<T> mTrash = new HashSet<>();

    SafeSet() { }

    public synchronized boolean add(T object) {
        return mSet.add(object);
    }

    public synchronized boolean remove(T other) {
        if (mSet.contains(other)) {
            for (T element: mSet) {
                if (element.equals(other)) {
                    mTrash.add(element);
                    mSet.remove(element);
                }
            }
        } else mTrash.remove(other);
        return true;
    }

    public synchronized boolean contains(T object) {
        return mSet.contains(object);
    }

    public static void main(String[] args) {
        SafeSet<String> a = new SafeSet<>();

        System.out.println(a.add("ciao"));
        System.out.println(a.add("mondo"));
        System.out.println(a.remove("ciao"));
        System.out.println(a.contains("ciao"));
        System.out.println(a.remove("ciao"));
        System.out.println(a.contains("ciao"));
    }
}
