package com.example.shoppingstore.domain.vendor;


import com.example.shoppingstore.web.vendor.VendorDTO;
import com.example.shoppingstore.web.vendor.VendorPKIdDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {

    List<Vendor> getVendors();

    Vendor addVendor(VendorDTO vendorDTO);

    Vendor getVendorByVendorPKId(VendorPKIdDTO vendorPKIdDTO);

    Vendor getVendorByName(String name);

    List<Address> getAddress();

}
