package com.ecommerce.order;

import com.ecommerce.product.Product;
import com.ecommerce.product.ProductDao;

import java.util.ArrayList;
import java.util.List;


public class OrderDao {
    private static List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) throws Exception {
        //Validate product availability

        Product product = new ProductDao().getProduct(order.getProductId());
        int availableQuantity = -1;
        if (product != null) {
            availableQuantity = product.getStockQuantity();
        }
        if (availableQuantity == -1) {
            //TODO: use custom Exception
            throw new Exception("Wrong product id");
        }
        else if (availableQuantity < order.getQuantity()) {
            //TODO: use custom Exception
            throw new Exception("Not sufficient product quantity");
        }
        orders.add(order);
        System.out.println("add order");
    }

    public List<Order> getAllOrders() {
        System.out.println("getAllOrders");
        return orders;
    }

}
