package com.example.shoppingstore.domain.vendor;


import com.example.shoppingstore.domain.product.ProductService;
import com.example.shoppingstore.web.vendor.VendorDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Component
public class VendorFactory {


    @Resource
    public ProductService productService;


    public Vendor ToVendedor(VendorDTO vendorDTO) {

        return Vendor.builder()
                .vendorPKId(vendorDTO.getVendorPKId())
                .address(createAddress(vendorDTO))
                .phones(vendorDTO.getPhones())
                .products(vendorDTO.getProducts()
                        .stream()
                        .map(idProduct -> productService.getProductById(idProduct).get())
                        .collect(Collectors.toList())
                )
                .build();
    }

    //TODO HOW HANDLE THE NULL POINTS
    public Vendor ToVendorUpdate(Vendor vendor, VendorDTO vendorDTO) {
        return vendor.reassamble(
                vendorDTO.getVendorPKId(),
                createAddress(vendorDTO),
                vendorDTO.getPhones(),
                vendorDTO.getProducts()
                        .stream()
                        .map(idProduct -> productService.getProductById(idProduct).get()
                        )
                        .collect(Collectors.toList())
        );
    }

    public Address createAddress(VendorDTO vendorDTO) {
        if (
                vendorDTO.getCity() != null &&
                        vendorDTO.getState() != null &&
                        vendorDTO.getStreet() != null &&
                        vendorDTO.getPincode() != null
        )
            return Address.builder()
                    .city(vendorDTO.getCity())
                    .state(vendorDTO.getState())
                    .street(vendorDTO.getStreet())
                    .pincode(vendorDTO.getPincode())
                    .build();
        //TODO I DONT LIKE RETURN A NULL
        return null;
    }


}
