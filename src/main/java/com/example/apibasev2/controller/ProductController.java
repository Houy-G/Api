package com.example.apibasev2.controller;

import com.example.apibasev2.model.Product;
import com.example.apibasev2.model.dto.ProductDto.ProductCreateDto;
import com.example.apibasev2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductCreateDto create){
        return productService.createProduct(create);
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductByUuid(id);
    }
}
