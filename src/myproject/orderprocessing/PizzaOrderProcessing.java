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

    public PizzaOrderProcessing(PizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;
        this.orderList = new ArrayList<>();
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

    public static void printCheck(double checkCost){
        System.out.println("Your check:");
        for(Pizza pizza : orderList){
            System.out.println((orderList.indexOf(pizza)+1) + ". " + pizza.getName());
            System.out.println("Price:                                $" + df.format(pizza.getPrice()));
        }
        System.out.println("...");
        System.out.println("Check Total: $" + df.format(checkCost));
    }
}
