package myproject.toppings;

import myproject.pizza.Pizza;

public class MushroomsTopping extends ToppingsDecorator{
    public MushroomsTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName() + " with mushroom";
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.99;
    }
}
