package com.example.shoppingstore.web.vendor;

import com.example.shoppingstore.domain.vendor.VendorPKId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorDTO {
    private Long id;

    private String name;
    private String city;
    private String state;
    private String street;
    private Long pincode;
    private Set<Long> phones;
    private List<Long> products;

    public VendorPKId getVendorPKId() {
        return new VendorPKId(this.id, this.name);
    }

}
