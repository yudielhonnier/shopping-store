package com.example.shoppingstore.domain.vendor;

import com.example.shoppingstore.web.vendor.VendorPKIdDTO;
import org.springframework.stereotype.Component;

@Component
public class VendorPKIdFactory {


    public VendorPKId toVendorPKId(VendorPKIdDTO vendorPKIdDTO){

        return VendorPKId.builder()
                .idVendor(vendorPKIdDTO.getIdVendor())
                .name(vendorPKIdDTO.getName())
                .build();
    }

    public VendorPKIdDTO toVendorPKIdDTO(VendorPKId vendorPKId){
        return VendorPKIdDTO.builder()
                .idVendor(vendorPKId.getIdVendor())
                .name(vendorPKId.getName())
                .build();
    }


}
