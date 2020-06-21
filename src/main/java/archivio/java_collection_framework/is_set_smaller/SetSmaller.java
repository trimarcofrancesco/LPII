package main.java.archivio.java_collection_framework.is_set_smaller;

import main.java.model.Employee;
import main.java.model.Manager;

import java.util.*;

public class SetSmaller {

    /*
    Implementare il metodo statico isSetSmaller, che accetta due insiemi e un comparatore,
    e restituisce vero se e solo se tutti gli elementi del primo insieme sono più piccoli,
    in base al comparatore, di tutti gli elementi del secondo insieme.

    Porre particolare attenzione alla scelta della firma.
     */

    /*public static <S extends T,T> boolean isSetSmaller(Set<S> set1, Set<T> set2, Comparator<? super T> comparator) {
        boolean flag = true;

        for(S el1: set1)
            for(T el2: set2) {
                if (comparator.compare(el1, el2) >= 0)
                    flag = false;

            }

        return flag;
    }*/

    // Più garanzie
    /*public static <T> boolean isSetSmaller(Set<? extends T> set1, Set<T> set2, Comparator<? super T> comparator) {
        boolean flag = true;

        for(T el1: set1)
            for(T el2: set2) {
                if (comparator.compare(el1, el2) >= 0)
                    flag = false;

            }

        return flag;
    }*/

    // Accetta anche Employee - Manager
    public static <T> boolean isSetSmaller(Set<? extends T> set1, Set<? extends T> set2, Comparator<? super T> comparator) {
        boolean flag = true;

        for(T el1: set1)
            for(T el2: set2) {
                if (comparator.compare(el1, el2) >= 0) {
                    flag = false;
                    break;
                }

            }

        return flag;
    }

    // Più permissiva ma non corretta (viola la pre-condizione)
    /*public static <T> boolean isSetSmaller(Collection<? extends T> set1, Collection<T> set2, Comparator<? super T> comparator) {
        boolean flag = true;

        for(T el1: set1)
            for(T el2: set2) {
                if (comparator.compare(el1, el2) >= 0)
                    flag = false;

            }

        return flag;
    }*/

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 6));

        System.out.println(SetSmaller.isSetSmaller(set1, set2, Integer::compareTo));


        Employee employee1 = new Employee("Marco Faella", 1000);
        Employee employee2 = new Employee("Adriano Peron", 3500);
        Employee employee3 = new Employee("Sergio Di Martino", 4000);
        Manager manager1 = new Manager("Tiberio Tiberi", 7849, 1000);

        Set<Employee> setOfEmployeeSmallerThen2 = new HashSet<>(Arrays.asList(employee1, employee2));
        Set<Employee> setOfEmployee2 = new HashSet<>(Arrays.asList(employee3));
        Set<Manager> setManager = new HashSet<>(Arrays.asList(manager1));

        System.out.println(SetSmaller.isSetSmaller(setOfEmployeeSmallerThen2, setOfEmployee2, Employee.comparatorBySalary));
        System.out.println(SetSmaller.isSetSmaller(setManager, setOfEmployeeSmallerThen2, Employee.comparatorBySalary));
        System.out.println(SetSmaller.isSetSmaller(setOfEmployeeSmallerThen2, setManager, Employee.comparatorBySalary));
        System.out.println(null instanceof Object);
    }
}
