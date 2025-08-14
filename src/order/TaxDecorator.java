package order;

// TaxDecorator.java — OCP: adiciona imposto sem mudar as outras classes (Decorator)
import java.math.BigDecimal;
import java.util.List;

public final class TaxDecorator implements TotalCalculator {
    private final TotalCalculator delegate;
    private final BigDecimal taxRate; // ex.: 0.10 = 10%

    public TaxDecorator(TotalCalculator delegate, BigDecimal taxRate) {
        this.delegate = delegate;
        this.taxRate = taxRate;
    }

    @Override
    public BigDecimal calculate(List<? extends Item> items) {
        BigDecimal subtotal = delegate.calculate(items);
        return subtotal.add(subtotal.multiply(taxRate));
    }
}
