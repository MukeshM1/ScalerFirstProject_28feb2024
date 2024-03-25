package dev.mukeshm1.scalerfirstproject_28feb2024.Services;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Category;
import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import dev.mukeshm1.scalerfirstproject_28feb2024.Reposiories.CategoryRepository;
import dev.mukeshm1.scalerfirstproject_28feb2024.Reposiories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository =categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return productRepository.findByIdIs(productId);
    }

    @Override
    public Product createProduct(String title, Double price, String category,
                                    String description, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(image);

        Category categoryFromDatebase = categoryRepository.findByTitle(category);

        if (categoryFromDatebase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDatebase = newCategory;
        }
        product.setCategory(categoryFromDatebase);
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteProductById(productId);
    }

    @Override
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String title) {
        return (List<Product>) productRepository.findAllByCategoryTitle(title);
    }

    @Override
    public Product updateProduct(Long productId, String title, Double price, String category,
                                    String description, String image) {
        Product p = productRepository.findByIdIs(productId);

        if(p != null) {
            if (title != null) {
                p.setTitle(title);
            }
            if (price != 0) {
                p.setPrice(price);
            }
            if (description != null) {
                p.setDescription(description);
            }
            if (image != null) {
                p.setImageURL(image);
            }
            if (category != null) {
                Category cat = categoryRepository.findByTitle(category);
                p.setCategory(cat);

            }
        }

        return productRepository.save(p);
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }
}
