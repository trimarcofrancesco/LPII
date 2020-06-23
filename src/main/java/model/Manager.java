package main.java.model;

public class Manager extends Employee {

    private double bonus;

    // This is the constructor of the class Manager
    public Manager(String name) {
        super(name);
    }

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    /* Assign the bonus to the variable bonus.*/
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /* Print the Employee details */
    @Override
    public void print() {
        super.print();
        System.out.println("Bonus: " + bonus);
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus: " + bonus;
    }
}
