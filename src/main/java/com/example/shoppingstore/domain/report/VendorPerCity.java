package com.example.shoppingstore.domain.report;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VendorPerCity {
    private String city;
    private Long countVendors;
}
