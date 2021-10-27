package com.example.shoppingstore.web.product;


import com.example.shoppingstore.domain.vendor.VendorPKId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Long id;

    private String name;

    private VendorPKId vendorPKId;

    private Long price;

}
