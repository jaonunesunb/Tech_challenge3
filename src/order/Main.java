package order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        TotalCalculator calc =
            new TaxDecorator(
                new DiscountDecorator(
                    new SumTotalCalculator(),
                    new BigDecimal("100.00"),
                    new BigDecimal("0.05")),
                new BigDecimal("0.10"));

        Order order = new Order(calc);
        order.addItem(new SimpleItem("A", new BigDecimal("80.00")));
        order.addItem(new SimpleItem("B", new BigDecimal("40.00")));

        BigDecimal total = order.total().setScale(2, RoundingMode.HALF_UP);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

        System.out.println(total);
        System.out.println(nf.format(total));
    }
}
