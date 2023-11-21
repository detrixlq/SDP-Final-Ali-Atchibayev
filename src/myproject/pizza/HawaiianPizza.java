package myproject.pizza;

public class HawaiianPizza implements Pizza{
    @Override
    public String getName() {
        return "Hawaiian Pizza";
    }

    @Override
    public double getPrice() {
        return 12.99;
    }
}
