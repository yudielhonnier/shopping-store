package com.example.shoppingstore.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable>, JpaSpecificationExecutor<Product> {


    Optional<Product> findByNameproduct(String name);

}
