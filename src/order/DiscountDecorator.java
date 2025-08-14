package order;

// DiscountDecorator.java — OCP: aplica desconto condicional (outro Decorator)
import java.math.BigDecimal;
import java.util.List;

public final class DiscountDecorator implements TotalCalculator {
    private final TotalCalculator delegate;
    private final BigDecimal threshold;   // aplica desconto se subtotal >= threshold
    private final BigDecimal discountRate; // ex.: 0.05 = 5%

    public DiscountDecorator(TotalCalculator delegate, BigDecimal threshold, BigDecimal discountRate) {
        this.delegate = delegate;
        this.threshold = threshold;
        this.discountRate = discountRate;
    }

    @Override
    public BigDecimal calculate(List<? extends Item> items) {
        BigDecimal subtotal = delegate.calculate(items);
        if (subtotal.compareTo(threshold) >= 0) {
            return subtotal.subtract(subtotal.multiply(discountRate));
        }
        return subtotal;
    }
}
