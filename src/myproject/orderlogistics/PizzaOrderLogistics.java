package myproject.orderlogistics;
import myproject.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;
public class PizzaOrderLogistics implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String orderStatus = "Order Placed";
    private List<Pizza> pizzas = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(orderStatus, pizzas);
        }
    }

    public void setOrderStatus(String newStatus, List<Pizza> pizzas) {
        this.orderStatus = newStatus;
        this.pizzas = pizzas;
        notifyObservers();
    }

    public void prepareOrder() {
        // Simulate the time it takes to prepare the order with a countdown
        for (int i = 5; i > 0; i--) {
            System.out.println("Preparing order... Time remaining: " + i + " minutes");
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Order prepared!");
        setOrderStatus("Prepared", pizzas);
    }

    public void deliverOrder(){
        for (int i = 10; i > 0; i--) {
            System.out.println("Delivering order... Time remaining: " + i + " minutes");
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Order delivered!");
        setOrderStatus("Delivered", pizzas);
    }
}
