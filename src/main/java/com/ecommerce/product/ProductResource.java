package com.ecommerce.product;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product")
public class ProductResource {
    ProductDao productDao = new ProductDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Path("/page={page}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(@PathParam("page") int page) {
        return productDao.getProducts(page);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
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

    @Path("/filter={category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByCategory(@PathParam("category") String category) {
        return productDao.getProductsByCategory(category);
    }

    @Path("/minPrice={minPrice}&&maxPrice={maxPrice}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsInPriceRange(@PathParam("minPrice") Double minPrice, @PathParam("maxPrice") Double maxPrice) {
        return productDao.getProductsInPriceRange(minPrice, maxPrice);
    }
}
