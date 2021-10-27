package com.example.shoppingstore.infraestructure.customer;


import com.example.shoppingstore.domain.customer.Customer;
import com.example.shoppingstore.domain.customer.CustomerFactory;
import com.example.shoppingstore.domain.customer.CustomerRepository;
import com.example.shoppingstore.domain.customer.CustomerService;
import com.example.shoppingstore.web.customer.CustomerDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Resource
    CustomerRepository customerRepository;
    @Resource
    CustomerFactory customerFactory;


    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
        GrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole().name());
        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), Arrays.asList(authority));
    }


    @Override
    public Customer save(CustomerDTO customerDTO) {
        customerRepository.save(customerFactory.customerDTOToCustomer(customerDTO));
        return null;
    }
}