package myproject.pizza;

public class PepperoniPizza implements Pizza{
    @Override
    public String getName() {
        return "Pepperoni Pizza";
    }
    @Override
    public double getPrice() {
        return 14.99;
    }
}
