package com.ecommerce;

import com.ecommerce.order.OrderResource;
import com.ecommerce.product.ProductResource;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        String BASE_URI = "http://localhost:8080/com/ecommerce";
        ResourceConfig resourceConfig = new ResourceConfig(OrderResource.class, ProductResource.class);
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        System.out.println("Server started at: " + BASE_URI);
    }
}
