package com.example.shoppingstore.domain.product;


import com.example.shoppingstore.domain.vendor.VendorPKId;
import com.example.shoppingstore.web.product.ProductForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductSpec {

    public static Specification<Product> listProduct(ProductForm productForm) {
        return (root, query, builder) -> {
            Join<Object, Object> vendor = root.join("vendor");
            List<Predicate> predicates = new ArrayList<>();

            if (productForm.getId() != null) {
                predicates.add(builder.equal(root.get("id"), productForm.getId()));


            }
            if (productForm.getVendorPKId() != null) {
                predicates.add(builder.equal(root.get("name"), productForm.getName()));
            }
            if (productForm.getVendorPKId() != null) {
                predicates.add(builder.equal(vendor.get("id"), productForm.getVendorPKId()));
            }
            if (productForm.getVendorPKId() != null) {
                predicates.add(builder.equal(root.get("price"), productForm.getPrice()));
            }

            query.orderBy(builder.asc(root.get("id")));
            Optional<Predicate> finalPredicate = predicates.stream().reduce(builder::and);
            return finalPredicate.orElse(null);
        };
    }

    public static Specification<Product> listProductByVendor(VendorPKId vendorPKId) {
        return (root, query, builder) -> {
            Join<Object, Object> vendor = root.join("vendor");

            List<Predicate> predicates = new ArrayList<>();
            if (vendorPKId != null) {
                predicates.add(builder.equal(vendor.get("id"), vendorPKId));
            }

            query.orderBy(builder.asc(root.get("id")));
            Optional<Predicate> finalPredicate = predicates.stream().reduce(builder::and);
            return finalPredicate.orElse(null);
        };


    }


}
