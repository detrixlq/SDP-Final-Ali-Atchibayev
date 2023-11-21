package myproject.pizza;

public class NeapolitanPizza implements Pizza{
    @Override
    public String getName() {
        return "Neapolitan Pizza";
    }
    @Override
    public double getPrice() {
        return 10.99;
    }
}
