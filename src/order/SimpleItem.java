package order;

// SimpleItem.java — exemplo de implementação de Item
import java.math.BigDecimal;
import java.util.Objects;

public final class SimpleItem implements Item {
    private final String sku;
    private final BigDecimal price;

    public SimpleItem(String sku, BigDecimal price) {
        this.sku = Objects.requireNonNull(sku);
        this.price = Objects.requireNonNull(price);
    }

    @Override public BigDecimal getPrice() { return price; }
    public String getSku() { return sku; }
}
