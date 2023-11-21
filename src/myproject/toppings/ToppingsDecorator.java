package myproject.toppings;

import myproject.pizza.Pizza;
//decorator pattern implementation
abstract class ToppingsDecorator implements Pizza{
    protected Pizza pizza;

    public ToppingsDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}
