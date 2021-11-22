package com.example.shoppingstore.domain.report;

import org.springframework.stereotype.Component;


@Component
public class VendorPerCityFactory {

    public VendorPerCity vendorPerCity(String city, Long countVendors) {
        return VendorPerCity.builder()
                .city(city)
                .countVendors(countVendors)
                .build();
    }


}
