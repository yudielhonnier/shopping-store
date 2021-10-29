package com.example.shoppingstore.domain.product;

import com.example.shoppingstore.domain.vendor.Vendor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -1777867143715036792L;

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dproduct_seq")
    @SequenceGenerator(name = "dproduct_seq", sequenceName = "dproduct_id_seq", allocationSize = 1)
    @Basic(optional = false)
    private Long id;

    @Column(name = "nameproduct", nullable = false, length = 30)
    private String nameproduct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumns(
            {
                    @JoinColumn(name = "idVendor"),
                    @JoinColumn(name = "name")
            }
    )
    private Vendor vendor;

    @Column(name = "price")
    private Long price;

    Product reassamble(String name, Vendor vendor, Long price) {
        this.nameproduct = name;
        this.vendor = vendor;
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + nameproduct + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return (this.id != null || product.id == null) && (this.id == null || this.id == product.id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = (id.hashCode() != 0) ? id.hashCode() : 0;
        return hash;
    }


}
