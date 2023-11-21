package myproject.orderlogistics;

import myproject.pizza.Pizza;

import java.util.List;

public class DeliverySystem implements Observer {
    public void update(String orderStatus, List<Pizza> pizzas) {
        System.out.println("Delivery System received order status: " + orderStatus);
    }
}
