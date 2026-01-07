package com.store.order;
import com.store.payment.Payable;

public class OnlineOrder extends Order implements Payable {
    public OnlineOrder(int orderId, double amount, OrderStatus status) {
        super(orderId, amount, status);
    }

    @Override
    public void processOrder() {
        System.out.println("---------------------------");
        System.out.println("Processing Order " + getOrderId());
    }

    @Override
    public void pay() {
        setStatus(OrderStatus.PAID);
        System.out.println("Order " + getOrderId() + " has been paid.\n");
    }
}
