package myproject.orderprocessing;

public class CurrencyAdapter implements Currency {
    private double exchangeRate;
    private Currency originalCurrency;

    public CurrencyAdapter(Currency originalCurrency, double exchangeRate){
        this.originalCurrency = originalCurrency;
        this.exchangeRate = exchangeRate;
    }
    @Override
    public String getSymbol() {
        return "₸";
    }
    @Override
    public double convertPrice(double originalPrice) {
        return originalPrice * exchangeRate;
    }
}
