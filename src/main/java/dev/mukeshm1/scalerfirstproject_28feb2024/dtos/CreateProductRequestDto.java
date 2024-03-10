package dev.mukeshm1.scalerfirstproject_28feb2024.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private Double price;
    private String catergory;
    private String discription;
    private String image;
}
