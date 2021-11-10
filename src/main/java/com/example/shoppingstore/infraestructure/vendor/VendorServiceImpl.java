package com.example.shoppingstore.infraestructure.vendor;


import com.example.shoppingstore.domain.vendor.*;
import com.example.shoppingstore.web.vendor.VendorDTO;
import com.example.shoppingstore.web.vendor.VendorPKIdDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    @Resource
    private VendorRepository vendorRepository;
    @Resource
    private VendorFactory vendorFactory;
    @Resource
    private VendorPKIdFactory vendorPKIdFactory;


    public List<Vendor> getVendors() {

        return vendorRepository.findAll();
    }

    public Vendor addVendor(VendorDTO vendorDTO) {

        return vendorRepository.save(vendorFactory.ToVendedor(vendorDTO));
    }


    public Vendor getVendorByVendorPKId(VendorPKIdDTO vendorPKIdDTO) {

        Optional<Vendor> vendor =
                vendorRepository.findById(vendorPKIdFactory.toVendorPKId(vendorPKIdDTO));
        System.out.println("vendor name======"+vendor.get().getVendorPKId().getName());
        return vendor.get();
    }


    public Vendor getVendorByName(String name) {

        Optional<Vendor> vendor = vendorRepository.findByVendorPKIdName(name);

        return vendor.get();
    }


    public List<Address> getAddress(){
        List<Address> addresses=vendorRepository.findAll()
                .stream()
                .map((vendor -> vendor.getAddress()))
                .collect(Collectors.toList());
        return addresses;
    }


}
