package com.example.shoppingstore.domain.product;

import com.example.shoppingstore.domain.vendor.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable>, JpaSpecificationExecutor<Product> {

    List<Product> findByVendor(Vendor vendor);

    Optional<Product> findByNameproduct(String name);

}
