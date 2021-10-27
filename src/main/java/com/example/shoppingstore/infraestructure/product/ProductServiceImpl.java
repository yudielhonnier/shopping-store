package com.example.shoppingstore.infraestructure.product;


import com.example.shoppingstore.domain.product.*;
import com.example.shoppingstore.domain.vendor.Vendor;
import com.example.shoppingstore.exceptions.ProductNotFoundException;
import com.example.shoppingstore.exceptions.ShoppingStoreException;
import com.example.shoppingstore.web.product.ProductDTO;
import com.example.shoppingstore.web.product.ProductForm;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

//TODO READ ABOUT SPY,SEARCH IN BAELDONG
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductFactory productFactory;


    public Page<Product> listProducts(ProductForm productForm, Pageable pageable) {
        return productRepository.findAll(ProductSpec.listProduct(productForm), pageable);
    }

    //If i don't use findByName then I go to take a bug
    @Override
    public Optional<Product> saveProduct(ProductDTO productDTO) {
        Optional<Product> productToFind = productRepository.findByNameproduct(productDTO.getName());
        Product productToSave;

        if (productToFind.isPresent()) {
            throw new ShoppingStoreException("THE PRODUCT ALREADY PERSISTS IN THE DATABASE");
        } else {
            productToSave = Optional.ofNullable(productRepository.save(productFactory.toProduct(productDTO)))
                    .orElseThrow(() -> new ShoppingStoreException("PROBLEMS SAVING THE PRODUCT"));
        }

        return Optional.ofNullable(productToSave);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("" + productId));
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> updateProduct(ProductDTO productDTO, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("" + productId));
        ;
        return Optional.ofNullable(productFactory.toProductUpdate(productDTO, product));
    }

    @Override
    public List<Product> listProductsByVendor(Vendor vendor) {
        return productRepository.findByVendor(vendor);
    }


    public Optional<Product> getProductByName(String name) {
        Product product = productRepository.findByNameproduct(name)
                .orElseThrow(() -> new ProductNotFoundException("NO EXIST PRODUCT WHIT THAT NAME"));
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> delProduct(Long id) {
        Optional<Product> toDelete = productRepository.findById(id);
        toDelete.ifPresent(productRepository::delete);
        return toDelete;
    }

}
