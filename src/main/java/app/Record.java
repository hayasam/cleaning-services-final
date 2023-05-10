package app;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Integer> type = new ArrayList<>();

    public boolean addOrder(Order order, Customer customer) {
        if (orders.contains(order))
            return false;

        orders.add(order);
        customers.add(customer);
        type.add(1);
        return true;

    }

    public boolean addVisit(Order order) {
        int index = orders.indexOf(order);
        if (index >= 0) {
            type.set(index, 2);
            return true;
        }

        return false;

    }

    public boolean deleteOrder(Order order) {
        int index = orders.indexOf(order);
        if (index >= 0) {
            orders.remove(index);
            customers.remove(index);
            type.remove(index);
            return true;
        }

        return false;

    }

    public boolean editOrder(Order oldOrder, Order newOrder) {
        if (orders.contains(newOrder))
            return false;

        int index = orders.indexOf(oldOrder);
        if (index >= 0) {
            orders.set(index, newOrder);
            return true;
        }

        return false;

    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Integer> getType() {
        return type;
    }




}
