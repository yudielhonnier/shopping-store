package com.example.shoppingstore.domain.vendor;


import com.example.shoppingstore.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "vendor")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 8548954762044567903L;

    @EmbeddedId
//    @Column(name = "vendorPKId")
    private VendorPKId vendorPKId;

    @Column(name = "address")
    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "vendor_phones",
            joinColumns = {@JoinColumn(name = "vendorId"), @JoinColumn(name = "name")}
    )
    @Column(name = "phone")
    private Set<Long> phones;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    Vendor reassamble(VendorPKId vendorPKId, Address address, Set<Long> phones, List<Product> products) {
        this.vendorPKId = vendorPKId;
        this.address = address;
        this.phones = phones;
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "idVendor=" + vendorPKId.getIdVendor() +
                ", name='" + vendorPKId.getName() + '\'' +
                ", address='" + address + '\'' +
                ", phones='" + phones + '\'' +
//                ", productos=" + producto1s +
                '}';
    }
}
