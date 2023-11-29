package com.ecommerce.order;

import java.util.ArrayList;
import java.util.List;


public class OrderDao {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        //Validate product availability
        orders.add(order);
        System.out.println("add order");
    }

}
