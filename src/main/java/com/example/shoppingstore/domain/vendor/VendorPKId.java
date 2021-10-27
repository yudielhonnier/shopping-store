package com.example.shoppingstore.domain.vendor;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class VendorPKId implements Serializable {


    @NotNull
    @Column(name = "idVendor")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dvendor_seq")
//    @SequenceGenerator(name = "dvendor_id_seq", allocationSize = 1)
    @Basic(optional = false)
    private Long idVendor;

    @Column(name = "name")
    private String name;

}
