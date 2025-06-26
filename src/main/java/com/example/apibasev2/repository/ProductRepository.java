package com.example.apibasev2.repository;

import com.example.apibasev2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByUuid(String uuid);
}
