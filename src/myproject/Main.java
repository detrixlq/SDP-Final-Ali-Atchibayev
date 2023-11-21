package myproject;
import myproject.orderprocessing.PizzaOrderProcessing;
import myproject.pizza.PizzaFactory;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PizzaFactory pizzaFactory = new PizzaFactory();


        PizzaOrderProcessing pizzaOrderProcessor = new PizzaOrderProcessing(pizzaFactory);
        System.out.println("Welcome to our Pizzeria!");
        System.out.println("...");
        while (true) {
            System.out.println("Choose your pizza:");
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

        double totalCost = PizzaOrderProcessing.calculateCheck();
        PizzaOrderProcessing.printCheck(totalCost);

    }
}