package com.example.shoppingstore.web.product;

//Duplicated code justify because i need keep the context
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
