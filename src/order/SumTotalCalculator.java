package order;

// SumTotalCalculator.java — OCP: uma estratégia concreta de cálculo
import java.math.BigDecimal;
import java.util.List;

public final class SumTotalCalculator implements TotalCalculator {
    @Override
    public BigDecimal calculate(List<? extends Item> items) {
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
