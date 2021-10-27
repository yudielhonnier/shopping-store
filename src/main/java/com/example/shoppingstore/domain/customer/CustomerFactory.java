package com.example.shoppingstore.domain.customer;

import com.example.shoppingstore.web.customer.CustomerDTO;
import org.springframework.stereotype.Component;


@Component
public class CustomerFactory {

    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .email(customerDTO.getEmail())
                .role(toRole(customerDTO.getRole()))
                .doj(customerDTO.convertDojToDate())
                //TODO SEE IF I CAN GET THE CURRENTUSER
                .createdBy("ADMIN")
                .build();
    }

    private Customer.Role toRole(String role) {
        switch (role) {
            case "USER": {
                return Customer.Role.USER;
            }
            case "ADMIN": {
                return Customer.Role.ADMIN;
            }
        }
        return null;
    }

}
