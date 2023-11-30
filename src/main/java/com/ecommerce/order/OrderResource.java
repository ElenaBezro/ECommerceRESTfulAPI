package com.ecommerce.order;


import com.ecommerce.product.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/order")
public class OrderResource {
    private OrderDao orderDao = new OrderDao();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
