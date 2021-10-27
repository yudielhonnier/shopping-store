package com.example.shoppingstore.domain.product;

import com.example.shoppingstore.domain.vendor.Vendor;
import com.example.shoppingstore.web.product.ProductDTO;
import com.example.shoppingstore.web.product.ProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Page<Product> listProducts(ProductForm productForm, Pageable pageable);

    Optional<Product> saveProduct(ProductDTO productDTO);

    Optional<Product> getProductById(Long productoId);

    Optional<Product> updateProduct(ProductDTO productDTO, Long id);

    //TODO CHECK THIS METHOD
    List<Product> listProductsByVendor(Vendor vendor);

    Optional<Product> getProductByName(String name);

    Optional<Product> delProduct(Long id);
}
