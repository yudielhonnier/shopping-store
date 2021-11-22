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
    @Basic(optional = false)
    private Long idVendor;

    @Column(name = "name")
    private String name;

}
