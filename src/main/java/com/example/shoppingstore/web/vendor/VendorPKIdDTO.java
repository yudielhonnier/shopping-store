package com.example.shoppingstore.web.vendor;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VendorPKIdDTO {

    private Long idVendor;

    private String name;

}
