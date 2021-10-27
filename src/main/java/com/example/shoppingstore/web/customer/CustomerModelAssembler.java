package com.example.shoppingstore.web.customer;

import com.example.shoppingstore.domain.customer.Customer;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CustomerModelAssembler extends RepresentationModelAssemblerSupport<Customer, CustomerModel> {

    public CustomerModelAssembler() {
        super(CustomerController.class, CustomerModel.class);
    }

    @Override
    public CustomerModel toModel(Customer customer) {
        CustomerModel customerModel = instantiateModel(customer);
        Link linkSelf = linkTo(methodOn(CustomerController.class).searchUserById(customer.getId())).withSelfRel();
        customerModel.add(linkSelf);
        customerModel.setEmail(customer.getEmail());
        customerModel.setPassword(customer.getPassword());
        customerModel.setRole(customer.getRole().name());

        return customerModel;
    }

    public List<CustomerModel> toCollectionModel(List<Customer> customers) {
        if (customers.isEmpty()) {
            return List.of();
        }

        return customers.stream().map(this::toModel).collect(Collectors.toList());
    }
}
