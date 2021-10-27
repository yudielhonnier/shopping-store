package com.example.shoppingstore.domain.vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, VendorPKId> {

    Optional<Vendor> findByVendorPKIdName(String name);



}
