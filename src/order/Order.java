package order;

// Order.java — SRP: gerencia itens; DIP: depende de TotalCalculator
import java.math.BigDecimal;
import java.util.*;

public final class Order {
    private final List<Item> items = new ArrayList<>();
    private final TotalCalculator calculator;

    public Order(TotalCalculator calculator) {
        this.calculator = Objects.requireNonNull(calculator);
    }

    public void addItem(Item item) { items.add(Objects.requireNonNull(item)); }
    public void removeItem(Item item) { items.remove(Objects.requireNonNull(item)); }
    public List<Item> items() { return Collections.unmodifiableList(items); }

    public BigDecimal total() { return calculator.calculate(items); }
}
