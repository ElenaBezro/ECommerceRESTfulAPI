package com.ecommerce.order;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/order")
public class OrderResource {
    private OrderDao orderDao = new OrderDao();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }
}
