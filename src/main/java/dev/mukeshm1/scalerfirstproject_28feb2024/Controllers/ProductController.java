package dev.mukeshm1.scalerfirstproject_28feb2024.Controllers;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import dev.mukeshm1.scalerfirstproject_28feb2024.Services.ProductService;
import dev.mukeshm1.scalerfirstproject_28feb2024.dtos.CreateProductRequestDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("selfProductService")ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products")
    public Product creatProduct(@RequestBody CreateProductRequestDto request) {
        return productService.createProduct(
                request.getTitle(), request.getPrice(), request.getCatergory(),
                request.getDiscription(), request.getImage()
        );
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id")Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getallproducts();
    }

    @GetMapping("/proucts/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody CreateProductRequestDto request) {
        return productService.updateProduct(
                productId, request.getTitle(), request.getPrice(), request.getCatergory(),
                request.getDiscription(), request.getImage()
        );
    }

    @GetMapping("/products/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }

}
