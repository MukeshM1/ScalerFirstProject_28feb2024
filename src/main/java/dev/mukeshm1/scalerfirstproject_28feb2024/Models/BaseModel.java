package dev.mukeshm1.scalerfirstproject_28feb2024.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass

public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDelete;
}
