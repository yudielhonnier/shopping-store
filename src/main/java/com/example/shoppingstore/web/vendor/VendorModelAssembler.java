package com.example.shoppingstore.web.vendor;

import com.example.shoppingstore.domain.vendor.Vendor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class VendorModelAssembler extends RepresentationModelAssemblerSupport<Vendor, VendorModel> {
    public VendorModelAssembler() {
        super(Vendor.class, VendorModel.class);
    }

    @Override
    public VendorModel toModel(Vendor vendor) {
        VendorModel vendorModel = instantiateModel(vendor);

        Link linkSelf = linkTo(methodOn(VendorController.class, vendor.getVendorPKId())).withSelfRel();
        vendorModel.add(linkSelf);
        //TODO FIX TOSTRING ADDRESS
        vendorModel.setAddress(vendor.getAddress().toString());
        vendorModel.setId(vendor.getVendorPKId().getIdVendor());
        vendorModel.setName(vendor.getVendorPKId().getName());
        vendorModel.setProducts(vendor.getProducts().stream().map(product -> product.getId()).collect(Collectors.toList()));
        return vendorModel;
    }


    public List<VendorModel> toCollectionModel(List<Vendor> vendors) {
        if (vendors.isEmpty()) return List.of();
        return vendors.stream().map(this::toModel).collect(Collectors.toList());
    }

}
