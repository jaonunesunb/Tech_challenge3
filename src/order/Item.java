package order;

// Item.java — ISP: interface mínima necessária
import java.math.BigDecimal;

public interface Item {
    BigDecimal getPrice();
}
