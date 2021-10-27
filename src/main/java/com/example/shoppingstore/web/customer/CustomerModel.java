package com.example.shoppingstore.web.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.xml.bind.annotation.XmlRootElement;

//TODO TO SEE WHAT MINNING THIS DECORATIONS
@Data
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "customer")
@JsonIgnoreProperties(ignoreUnknown = true)
class CustomerModel extends RepresentationModel<CustomerModel> {

    String email;
    String password;
    String role;
}
