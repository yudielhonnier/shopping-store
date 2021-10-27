package com.example.shoppingstore.web.product;

import com.example.shoppingstore.domain.product.Product;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {


    public ProductModelAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(Product product) {
        ProductModel productModel = instantiateModel(product);
        Link linkSelf = linkTo(methodOn(ProductController.class).getProductById(product.getId())).withSelfRel();
        productModel.add(linkSelf);
        productModel.setName(product.getNameproduct());
        productModel.setIdvendedor(product.getVendor().getVendorPKId().getIdVendor());
        productModel.setPrecio(product.getPrice());

        return productModel;
    }


    public List<ProductModel> toCollectionModel(List<Product> products) {
        if (!products.isEmpty())
            return products.stream().map(product -> toModel(product)).collect(Collectors.toList());
        return List.of();
    }
}
