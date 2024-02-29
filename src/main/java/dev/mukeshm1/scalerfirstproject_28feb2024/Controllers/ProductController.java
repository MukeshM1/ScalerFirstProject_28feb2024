package dev.mukeshm1.scalerfirstproject_28feb2024.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @PostMapping("/products")
    public void creatProduct() {

    }
    @GetMapping("/products/{id}")
    public void getProductDetails(@PathVariable("id") Long productId) {

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
