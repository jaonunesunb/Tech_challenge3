package order;

// TotalCalculator.java — DIP: abstração para cálculo do total
import java.math.BigDecimal;
import java.util.List;

public interface TotalCalculator {
    BigDecimal calculate(List<? extends Item> items);
}
