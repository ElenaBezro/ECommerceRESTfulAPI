package com.ecommerce.order;

import com.ecommerce.product.Product;

import java.util.ArrayList;
import java.util.List;


public class OrderDao {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        //Validate product availability
        orders.add(order);
        System.out.println("add order");
    }

    public List<Order> getAllOrders() {
        System.out.println("getAllOrders");
        return orders;
    }

}
