package dev.mukeshm1.scalerfirstproject_28feb2024.Services;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }
}
