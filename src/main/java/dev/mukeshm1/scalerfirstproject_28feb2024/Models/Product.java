package dev.mukeshm1.scalerfirstproject_28feb2024.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Long id;
    private String title;
    private Double price;
    private Category category;
    private String description;
    private String imageURL;

}
