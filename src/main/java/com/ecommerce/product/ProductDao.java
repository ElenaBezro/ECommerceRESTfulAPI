package com.ecommerce.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ProductDao {
    private static List<Product> products = new ArrayList<>();
    private static final int PRODUCTS_PER_PAGE = 5;

    public List<Product> getAllProducts() {
        System.out.println("getAllProducts");
        return products;
    }

    public List<Product> getProducts(int page) {
        System.out.println("getProducts with pagination");

        return IntStream.range(0, products.size())
                .filter(i -> i >= (page - 1) * PRODUCTS_PER_PAGE && i < page * PRODUCTS_PER_PAGE)
                .mapToObj(i -> products.get(i))
                .toList();
    }

    public void addProduct(Product product) {
        System.out.println("addProduct");
        products.add(product);
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (updatedProduct.getId() == products.get(i).getId()) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    public Product getProduct(int id) {
        System.out.println("getProduct");
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public List<Product> getProductsInPriceRange(Double minPrice, Double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .toList();
    }
}
