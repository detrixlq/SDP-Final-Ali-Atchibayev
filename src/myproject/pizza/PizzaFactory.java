package myproject.pizza;

//factory method implementation
public class PizzaFactory {
    public Pizza createMargheritaPizza(){
        return new MargheritaPizza();
    }
    public Pizza createNeapolitanPizza(){
        return new NeapolitanPizza();
    }
    public Pizza createHawaiianPizza(){
        return new HawaiianPizza();
    }
    public Pizza createPepperoniPizza(){
        return new PepperoniPizza();
    }
}
