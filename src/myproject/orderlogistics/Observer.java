package myproject.orderlogistics;

import myproject.pizza.Pizza;

import java.util.List;
//the whole package is an implementation of a delivery system based on an observer pattern
public interface Observer {
    void update(String orderStatus, List<Pizza> pizzas);
}
