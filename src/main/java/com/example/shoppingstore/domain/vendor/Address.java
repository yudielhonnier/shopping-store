package com.example.shoppingstore.domain.vendor;


import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE) //to make protected
@NoArgsConstructor(access = AccessLevel.PACKAGE) //to make protected
@Getter
@Setter(value=AccessLevel.PACKAGE) //to make protected
public class Address {

    private String city;
    private String state;
    private String street;
    private Long pincode;


}
