package streams.entity;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Order> orders;

    public User()
    {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public List<Order> getOrders()
    {
        return  this.orders;
    }
}
