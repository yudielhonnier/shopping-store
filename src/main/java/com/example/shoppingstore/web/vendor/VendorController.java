package com.example.shoppingstore.web.vendor;


import com.example.shoppingstore.domain.vendor.Vendor;
import com.example.shoppingstore.domain.vendor.VendorService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO ADD METHODS THAT CALL HATEOAS RESOURCES
@RestController
@RequestMapping("api/v1.0/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final @NotNull
    VendorService vendorService;

    private final @NotNull

    ResponseEntity<List<Vendor>> getVendors() {
        List<Vendor> listVendor = vendorService.getVendors();
        return ResponseEntity.ok(listVendor);
    }

    @PostMapping
    public ResponseEntity<Vendor> addVendor(@RequestBody VendorDTO vendorDTO) {
        Vendor vendorAdded = vendorService.addVendor(vendorDTO);
        return ResponseEntity.ok(vendorAdded);
    }

    //TODO FIX VENDORPKIID PROBLEM
    @GetMapping
    public ResponseEntity<Vendor> getVendorByVendorPKId(@RequestBody VendorPKIdDTO vendorPKIdDTO) {
        Vendor vendorObteined = vendorService.getVendorByVendorPKId(vendorPKIdDTO);
        return ResponseEntity.ok(vendorObteined);
    }

    //TODO FIX ADDRESS CONSTRUCTOR
    @GetMapping(value = "name/{name}")
    public ResponseEntity<Vendor> getVendorsByName(@PathVariable String name) {
        Vendor vendorObteined = vendorService.getVendorByName(name);
        return ResponseEntity.ok(vendorObteined);
    }





}
