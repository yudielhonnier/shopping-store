package com.example.shoppingstore.web.vendor;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class VendorForm {

    private Long id;
    private String name;
    private String address;
    private List<Long> products;

}
