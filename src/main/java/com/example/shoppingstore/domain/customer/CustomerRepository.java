package com.example.shoppingstore.domain.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);

    Page<Customer> findByEmailContains(String email, Pageable pageable);

    Page<Customer> findAllByEmail(String email, Pageable pageable);

    Page<Customer> findAllByEmailContainsAndEmail(String email, String auth, Pageable pageable);

    Page<Customer> getAllById(Long id, Pageable pageable);

    Boolean existsByEmail(String email);
}