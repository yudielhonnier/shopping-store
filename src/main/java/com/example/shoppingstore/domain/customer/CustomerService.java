package com.example.shoppingstore.domain.customer;

import com.example.shoppingstore.web.customer.CustomerDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends UserDetailsService {


    Customer save(CustomerDTO customerDTO);


}
