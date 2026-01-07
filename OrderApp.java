import java.util.ArrayList;
import java.util.Iterator;


enum OrderStatus {
    PENDING,
    PAID,
    SHIPPED,
    CANCELLED
}


abstract class Order {
    private int orderId;
    private double amount;
    private OrderStatus status;

    public Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public abstract void processOrder();

    public String getOrderSummary() {
        return String.format("Order ID: %d, Amount: %.2f, Status: %s", orderId, amount, status);
    }

  
    public int getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public OrderStatus getStatus() { return status; }


    public void setAmount(double amount) {
        if (amount >= 0) this.amount = amount;
    }

    protected void setStatus(OrderStatus status) {
        this.status = status;
    }
}


interface Payable {
    void pay();
}


class OnlineOrder extends Order implements Payable {

    public OnlineOrder(int orderId, double amount) {
        super(orderId, amount);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing online order: " + getOrderId());
    }

    @Override
    public void pay() {
        setStatus(OrderStatus.PAID);
        System.out.println("Order ID " + getOrderId() + " has been paid.");
    }

    
    public void cancelOrder() {
        setStatus(OrderStatus.CANCELLED);
        System.out.println("Order ID " + getOrderId() + " has been cancelled.");
    }
}


public class OrderApp {
    public static void main(String[] args) {

        
        ArrayList<Order> orders = new ArrayList<>();

        
        OnlineOrder order1 = new OnlineOrder(1, 100.0);
        OnlineOrder order2 = new OnlineOrder(2, 200.0);
        OnlineOrder order3 = new OnlineOrder(3, 300.0);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        
        order1.processOrder();
        order1.pay();

        order2.processOrder();
        order2.pay();

        order3.processOrder();
        order3.cancelOrder(); 

        
        Iterator<Order> iterator = orders.iterator();
        System.out.println("\nOrder Summary:");
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());
            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
            }
        }

        
        System.out.println("\nRemaining orders after removal:");
        for (Order order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }
}