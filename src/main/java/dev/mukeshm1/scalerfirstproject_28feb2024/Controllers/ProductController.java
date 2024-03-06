package dev.mukeshm1.scalerfirstproject_28feb2024.Controllers;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import dev.mukeshm1.scalerfirstproject_28feb2024.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void creatProduct() {

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    public void updateProduct() {

    }

    @DeleteMapping("/products")
    public void deleteProduct() {

    }
}
