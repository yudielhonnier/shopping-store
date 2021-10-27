package com.example.shoppingstore.web.product;

import com.example.shoppingstore.domain.vendor.VendorPKId;
import lombok.*;


@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {

    private Long id;

    private String name;

    private VendorPKId vendorPKId;

    private Long price;

}
