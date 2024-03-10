package dev.mukeshm1.scalerfirstproject_28feb2024.dtos;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Category;
import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String catergory;
    private String discription;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        Category productCategory = new Category();
        productCategory.setTitle(catergory);
        product.setCategory(productCategory);

        product.setDescription(discription);
        product.setImageURL(image);

        return product;
    }
}
