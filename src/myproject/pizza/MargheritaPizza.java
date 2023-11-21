package myproject.pizza;

public class MargheritaPizza implements Pizza {
    @Override
    public String getName() {
        return "Margherita Pizza";
    }
    @Override
    public double getPrice() {
        return 9.99;
    }
}
