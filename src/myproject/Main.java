package myproject;
import myproject.orderlogistics.*;
import myproject.orderprocessing.*;
import myproject.pizza.Pizza;
import myproject.pizza.PizzaFactory;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PizzaFactory pizzaFactory = new PizzaFactory();

        Currency usd = new USD();

        PizzaOrderLogistics pizzaOrder = new PizzaOrderLogistics();
        Kitchen kitchen = new Kitchen();
        DeliverySystem deliverySystem = new DeliverySystem();
        CustomerInterface customerInterface = new CustomerInterface();

        PizzaOrderProcessing pizzaOrderProcessor = PizzaOrderProcessing.getInstance(pizzaFactory, usd);
        List<Pizza> pizzasInOrder = pizzaOrderProcessor.returnOrder();
        System.out.println("Welcome to our Pizzeria!");
        System.out.println("...");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pepperoni $14.99");
            System.out.println("2. Neapolitan $10.99");
            System.out.println("3. Hawaiian $12.99 ");
            System.out.println("4. Margherita $9.99");
            int pizzaType = scanner.nextInt();
            System.out.println("Would you like any toppings?");
            System.out.println("1. Extra Cheese $1.25");
            System.out.println("2. Mushrooms $1.99");
            System.out.println("3. Pineapple $1.75");
            System.out.println("4. None");
            int toppingType = scanner.nextInt();
            PizzaOrderProcessing.addToOrder(pizzaType, toppingType);
            System.out.println("Press 1 to order more and 2 to proceed to checkout.");
            int proceed = scanner.nextInt();
            if(proceed == 2){
                break;
            }
        }
        //registering the order observers
        pizzaOrder.registerObserver(kitchen);
        pizzaOrder.registerObserver(deliverySystem);
        pizzaOrder.registerObserver(customerInterface);

        double totalCost = PizzaOrderProcessing.calculateCheck();
        PizzaOrderProcessing.printCheck(totalCost, usd);
        System.out.println("...");
        System.out.println("Would you like to print the receipt in KZT?");
        System.out.println("1. Yes     2. No");
        int adapter = scanner.nextInt();
        if(adapter == 1){
            CurrencyAdapter kzt = new CurrencyAdapter(usd, 458.63);
            PizzaOrderProcessing.printCheck(totalCost, kzt);
        }

        System.out.println("How do you wish to receive you order?");
        System.out.println("1. Dine-In    2. Delivery");
        int deliveryType = scanner.nextInt();

        pizzaOrder.setOrderStatus("Preparing", pizzasInOrder);
        pizzaOrder.prepareOrder();

        if(deliveryType == 2){
            pizzaOrder.setOrderStatus("Out for Delivery", pizzasInOrder);
            pizzaOrder.deliverOrder();
        } else {
            pizzaOrder.setOrderStatus("Delivered", pizzasInOrder);
        }

    }
}