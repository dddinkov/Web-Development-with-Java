package streams.entity;
import streams.vo.OrderStatus;
import streams.vo.PaymentMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Order {
    private static long availableId = 1000;
    private long id;
    private List<OrderLine> orderLines;
    private LocalDate orderDate;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

    public Order(PaymentMethod paymentMethod)
    {
        this.id = getNextId();
        this.orderDate = LocalDate.now();
        this.status = OrderStatus.DRAFT;
        this.paymentMethod = paymentMethod;
        this.orderLines = new ArrayList<>();
    }

    public long getId()
    {
        return this.id;
    }

    public void addOrderLine(OrderLine orderLine)
    {
        this.orderLines.add(orderLine);
    }

    public List<OrderLine> getOrderLines()
    {
        return this.orderLines;
    }

    public LocalDate getOrderDate()
    {
        return this.orderDate;
    }

    public OrderStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod()
    {
        return this.paymentMethod;
    }

    public static long getNextId()
    {
        return Order.availableId++;
    }

    public BigDecimal getTotalCost()
    {
        BigDecimal sum = new BigDecimal(0);
        for(OrderLine line : this.orderLines)
        {
            BigDecimal quantity = new BigDecimal(line.getQuantity());
            BigDecimal itemCost = line.getItem().getPrice();
            BigDecimal totalLineCost = itemCost.multiply(quantity);
            sum = sum.add(totalLineCost);
        }
        return sum;
    }
}
