package com.ecommerce.product;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product")
public class ProductResource {
    private static ProductDao productDao = new ProductDao();

    public ProductResource() {
        System.out.println("ProductResource constructor called");
    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Product> getAllProducts() {
//        return productDao.getAllProducts();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(@QueryParam("page") @DefaultValue("1") int page) {
        return productDao.getProducts(page);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
        //TODO: validate if id already exists
        productDao.addProduct(product);
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(@PathParam("id") int id, Product updatedProduct) {
        //TODO: use id in the method
        productDao.updateProduct(updatedProduct);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return productDao.getProduct(id);
    }

    @GET
    @Path("/byCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByCategory(@QueryParam("category")  String category) {
        return productDao.getProductsByCategory(category);
    }

    @GET
    @Path("/inPriceRange")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsInPriceRange(@QueryParam("minPrice") Double minPrice, @QueryParam("maxPrice") Double maxPrice) {
        return productDao.getProductsInPriceRange(minPrice, maxPrice);
    }
}
