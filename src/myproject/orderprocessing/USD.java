package myproject.orderprocessing;

public class USD implements Currency{
    @Override
    public String getSymbol() {
        return "$";
    }

    @Override
    public double convertPrice(double originalPrice) {
        return originalPrice;
    }
}
