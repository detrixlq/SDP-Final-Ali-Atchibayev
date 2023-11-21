package myproject.toppings;

import myproject.pizza.Pizza;

public class ExtraCheeseTopping extends ToppingsDecorator{
    public ExtraCheeseTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName() + " with extra cheese";
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.25;
    }
}
