package dev.mukeshm1.scalerfirstproject_28feb2024.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product extends BaseModel{
    private String title;
    private Double price;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    private String description;
    private String imageURL;

}
