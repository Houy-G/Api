package com.example.apibasev2.mapper;

import com.example.apibasev2.model.Product;
import com.example.apibasev2.model.dto.ProductDto.ProductCreateDto;

import java.util.UUID;

public class ProductMapper {
    public static Product mapFromProductDtoToProduct(ProductCreateDto create){
        return Product.builder()
                .uuid(UUID.randomUUID().toString())
                .tittle(create.tittle())
                .rating(create.rating())
                .image(create.image())
                .price(create.price())
                .description(create.description())
                .build();
    }
}
