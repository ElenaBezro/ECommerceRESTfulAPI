package com.ecommerce.order;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/order")
public class OrderResource {
    private static  OrderDao orderDao = new OrderDao();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order) {
        try {
            orderDao.addOrder(order);
            return Response.status(Response.Status.CREATED)
                    .build();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
