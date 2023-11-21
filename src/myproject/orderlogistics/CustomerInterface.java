package myproject.orderlogistics;

import myproject.pizza.Pizza;

import java.util.List;

public class CustomerInterface implements Observer{
    @Override
    public void update(String orderStatus, List<Pizza> pizzas) {
        System.out.println("Customer Interface received order status: " + orderStatus);
    }
}
