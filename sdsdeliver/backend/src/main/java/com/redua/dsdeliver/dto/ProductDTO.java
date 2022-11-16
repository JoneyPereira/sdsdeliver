package com.redua.dsdeliver.dto;

import com.redua.dsdeliver.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product entity) {

        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }
}
