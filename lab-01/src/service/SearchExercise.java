package service;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import streams.entity.*;
import streams.vo.*;

public class SearchExercise {
    public static List<Order> getActiveOrders(User user)
    {
        if(user == null)
        {
            return null;
        }
        List<Order> orders = user.getOrders();
        List<Order> activeOrders = new ArrayList<>();
        for(int i = 0; i < orders.size(); ++i)
        {
            Order order = orders.get(i);
            if(order.getStatus() == OrderStatus.ACTIVE)
            {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    public static List<Order> getActiveOrdersByIteration(User user)
    {
        if(user == null)
        {
            return null;
        }
        List<Order> orders = user.getOrders();
        List<Order> activeOrders = new ArrayList<>();
        for(Order order : orders)
        {
            if(order.getStatus() == OrderStatus.ACTIVE)
            {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    public static Order getOrderById(List<Order> orders, long orderId)
    {
        if(orders == null)
        {
            return null;
        }

        for(int i = 0; i < orders.size(); ++i)
        {
            Order order = orders.get(i);
            if(order.getId() == orderId)
            {
                return order;
            }
        }

        return null;
    }

    public static Order getOrderByIdIteration(List<Order> orders, long orderId)
    {
        if(orders == null)
        {
            return null;
        }

        for(Order order : orders)
        {
            if(order.getId() == orderId)
            {
                return order;
            }
        }

        return null;
    }

    public static List<Order> getOrdersThatHaveItemDescription(User user, String description)
    {
        List<Order> ordersThatHaveItemDescription = new ArrayList<>();
        for(Order order : user.getOrders())
        {
            for(OrderLine line : order.getOrderLines())
            {
                if(line.getItem().getDescription().equals(description))
                {
                    ordersThatHaveItemDescription.add(order);
                    break;
                }
            }
        }
        return ordersThatHaveItemDescription;
    }

    public static boolean hasActiveOrders(User user)
    {
        if(user == null)
        {
            return false;
        }

        for(Order order : user.getOrders())
        {
            if(order.getStatus() == OrderStatus.ACTIVE)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean canBeReturned(Order order)
    {
        for(OrderLine orderLine : order.getOrderLines())
        {
            if(orderLine.isSpecialOffer())
            {
                return false;
            }
        }
        return true;
    }

    public static Order getMaxPriceOrder(User user)
    {
        if(user == null || user.getOrders().size() == 0)
        {
            return null;
        }
        List<Order> orders = user.getOrders();
        Order maxPriceOrder = orders.getFirst();
        BigDecimal maxPrice = orders.getFirst().getTotalCost();
        for(Order order : orders)
        {
            BigDecimal orderTotalCost = order.getTotalCost();
            if(maxPrice.compareTo(orderTotalCost) < 0)
            {
                maxPriceOrder = order;
                maxPrice = orderTotalCost;
            }
        }
        return maxPriceOrder;
    }
}
