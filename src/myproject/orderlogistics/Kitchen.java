package myproject.orderlogistics;

import myproject.pizza.Pizza;

import java.util.List;

public class Kitchen implements Observer{
    @Override
    public void update(String orderStatus, List<Pizza> pizzas) {
        System.out.println("Kitchen received order status: " + orderStatus);
        System.out.println("Pizzas in the order: ");
        for(Pizza pizza : pizzas){
            System.out.println(pizza.getName());
        }
    }

}
