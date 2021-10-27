package com.example.shoppingstore.domain.product;


import com.example.shoppingstore.web.product.ProductForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO INCLUDE HIBERNATE DEPENDENCY IN POM

//TODO STUDY SPECIFICATIONS

public class ProductSpec {

    public static Specification<Product> listProduct(ProductForm productForm) {
        return (root, query, builder) -> {
            Join<Object, Object> vendor = root.join("vendor");

            List<Predicate> predicates = new ArrayList<>();
            if (productForm.getVendorPKId() != null) {
                predicates.add(builder.equal(vendor.get("id"), productForm.getId()));
            }

            query.orderBy(builder.asc(root.get("id")));
            Optional<Predicate> finalPredicate = predicates.stream().reduce(builder::and);
            return finalPredicate.orElse(null);
        };


    }


}
