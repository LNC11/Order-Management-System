package com.store.order;

public class Order {
    private int orderId;
    private double amount;
    private OrderStatus status;

    public Order(int orderId, double amount, OrderStatus status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setAmount(double amount) {
        if (amount >= 0) this.amount = amount;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void processOrder() {

    }

    public String getOrderSummary() {
        return "ID: " + getOrderId() + " | Total: " + amount + " | Status: " + status;
    }
}
