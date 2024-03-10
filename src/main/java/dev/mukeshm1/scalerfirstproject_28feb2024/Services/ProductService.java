package dev.mukeshm1.scalerfirstproject_28feb2024.Services;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);

    Product createProduct(String title, Double price, String category, String description, String image);

    void deleteProduct(Long productId);

    List<Product> getallproducts();

    List<Product> getProductsByCategory(String category);

    Product updateProduct(Long productId, String title, Double price, String category, String description, String image);

    List<String> getAllCategories();
}
