package com.example.apibasev2.model.dto.ProductDto;

public record ProductCreateDto(
        String tittle,
        Float price,
        String image,
        String description,
        Float rating
) { }
