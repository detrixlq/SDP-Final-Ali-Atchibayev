package myproject.orderprocessing;

import myproject.pizza.Pizza;
import myproject.pizza.PizzaFactory;
import myproject.toppings.ExtraCheeseTopping;
import myproject.toppings.MushroomsTopping;
import myproject.toppings.PineappleTopping;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;

//order processing logic
public class PizzaOrderProcessing {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static PizzaFactory pizzaFactory;
    private static List<Pizza> orderList;
    private static Currency currency;
    public PizzaOrderProcessing(PizzaFactory pizzaFactory, Currency currency){
        this.pizzaFactory = pizzaFactory;
        this.orderList = new ArrayList<>();
        this.currency = currency;
    }

    public static void addToOrder(int pizzaType, int toppingType){
        Pizza pizza = createPizza(pizzaType);
        pizza = addToppings(pizza, toppingType);
        orderList.add(pizza);
    }

    public static Pizza createPizza(int pizzaType){
        switch (pizzaType) {
            case 1:
                return pizzaFactory.createPepperoniPizza();
            case 2:
                return pizzaFactory.createNeapolitanPizza();
            case 3:
                return pizzaFactory.createHawaiianPizza();
            case 4:
                return pizzaFactory.createMargheritaPizza();
            default:
                throw new IllegalArgumentException("Invalid pizza type");
        }
    }

    public static Pizza addToppings(Pizza pizza, int toppingType){
        switch (toppingType){
            case 1:
                return new ExtraCheeseTopping(pizza);
            case 2:
                return new MushroomsTopping(pizza);
            case 3:
                return new PineappleTopping(pizza);
            case 4:
                return pizza;
            default:
                throw new IllegalArgumentException("Invalid topping type");
        }
    }

    public static double calculateCheck(){
        double checkCost = 0;
        for(Pizza pizza : orderList){
            checkCost += pizza.getPrice();
        }
        return checkCost;
    }

    public static void printCheck(double checkCost, Currency currency){

        System.out.println("Your check:");
        double checkTotal = currency.convertPrice(checkCost);
        for(Pizza pizza : orderList){
            double currentPrice = currency.convertPrice(pizza.getPrice());
            System.out.println((orderList.indexOf(pizza)+1) + ". " + pizza.getName());
            System.out.println("Price:                                "+ currency.getSymbol() + df.format(currentPrice));
        }
        System.out.println("...");
        System.out.println("Check Total:                          " + currency.getSymbol() + df.format(checkTotal));
    }
}
