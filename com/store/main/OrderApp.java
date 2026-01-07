package com.store.main;
import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();

        OnlineOrder order1 = new OnlineOrder(01, 100, OrderStatus.PENDING);
        OnlineOrder order2 = new OnlineOrder(02, 100, OrderStatus.PENDING);
        OnlineOrder order3 = new OnlineOrder(03, 100, OrderStatus.PENDING);

        orders.add(order1);
        System.out.println("Order 1 has been added.");
        orders.add(order2);
        System.out.println("Order 2 has been added.");
        orders.add(order3);
        System.out.println("Order 3 has been added.\n");

        order1.processOrder();
        order1.pay();
        order2.processOrder();
        order2.pay();
        order3.processOrder();
        order3.pay();

        order3.setStatus(OrderStatus.CANCELLED);
        System.out.println("Order 3 has been cancelled.");

        System.out.println("\n------- Order Summary -------");
        Iterator<Order> iterator = orders.iterator();
        while(iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());
            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
            }
        }

        System.out.println("\n------ Updated Order Summary ------");
        for (Order order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }
}
