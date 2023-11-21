package myproject.orderprocessing;

public interface Currency {
    String getSymbol();
    double convertPrice(double originalPrice);
}
