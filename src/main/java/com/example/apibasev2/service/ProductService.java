package com.example.apibasev2.service;

import com.example.apibasev2.mapper.ProductMapper;
import com.example.apibasev2.model.Product;
import com.example.apibasev2.model.dto.ProductDto.ProductCreateDto;
import com.example.apibasev2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepository productRepository;
    public List<Product>  getAllProduct(){
        return  productRepository.findAll();
    }
    public Product createProduct(ProductCreateDto create){
        return productRepository.save(ProductMapper.mapFromProductDtoToProduct(create));
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByUuid(String uuid){
        return  productRepository.findProductByUuid(uuid);
    }
 }
