package myproject.toppings;

import myproject.pizza.Pizza;

public class PineappleTopping extends ToppingsDecorator{

    public PineappleTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName() + " with pineapple";
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.75;    }
}
