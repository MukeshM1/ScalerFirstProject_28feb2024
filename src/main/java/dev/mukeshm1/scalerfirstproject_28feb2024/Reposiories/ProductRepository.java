package dev.mukeshm1.scalerfirstproject_28feb2024.Reposiories;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByIdIs(Long id);
    Product save(Product p);
    @Transactional
    void deleteProductById(Long id);
    List<Product> findAll();

    Product findAllByCategoryTitle(String title);
}
