package dev.mukeshm1.scalerfirstproject_28feb2024.Services;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import dev.mukeshm1.scalerfirstproject_28feb2024.dtos.FakeStoreProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("fakeStoreProductService")

public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId,
                        FakeStoreProductDto.class
                );

        return fakeStoreProduct.toProduct();
    }


    @Override
    public Product createProduct(String title, Double price, String category,
                                    String description, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCatergory(category);
        fakeStoreProductDto.setDiscription(description);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject
                ("https://fakestoreapi.com/products",
                        fakeStoreProductDto, FakeStoreProductDto.class
                );

        return response.toProduct();
    }

    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete("https://fakestoreapi.com/products/" + productId);
    }

    @Override
    public List<Product> getallproducts() {
        List<Product> productList = new ArrayList<>();

        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        for (int i = 0;  i < fakeStoreProducts.length;  i++) {
            productList.add(fakeStoreProducts[i].toProduct());
        }

        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(String caterogy) {
        List<Product> productList = new ArrayList<>();

        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + caterogy,
                        FakeStoreProductDto[].class
                );
        for (int i = 0;  i < fakeStoreProducts.length;  i++) {
            productList.add(fakeStoreProducts[i].toProduct());
        }

        return productList;
    }

    @Override
    public Product updateProduct(Long productId, String title, Double price, String category,
                                    String description, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(productId);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCatergory(category);
        fakeStoreProductDto.setDiscription(description);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto updatedProductDto = restTemplate.patchForObject
                ("https://fakestoreapi.com/products/" + productId,
                        fakeStoreProductDto, FakeStoreProductDto.class
                );

        return updatedProductDto.toProduct();
    }

    @Override
    public List<String> getAllCategories() {
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity
                ("https://fakestoreapi.com/products/categories", String[].class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<String> categoryList = Arrays.stream(responseEntity.getBody()).toList();
            return categoryList;
        }
        else {
            return Collections.emptyList();
        }
    }

}
