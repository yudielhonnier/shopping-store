package com.example.shoppingstore.domain.product;

import com.example.shoppingstore.web.product.ProductDTO;
import com.example.shoppingstore.web.product.ProductForm;
import com.example.shoppingstore.web.product.VendorPKIdDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Page<Product> listProducts(ProductForm productForm, Pageable pageable);

    Page<Product> listProductsByVendor(VendorPKIdDTO vendorPKIdDTO, Pageable pageable);

    Optional<Product> saveProduct(ProductDTO productDTO);

    Optional<Product> getProductById(Long productoId);

    Optional<Product> updateProduct(ProductDTO productDTO, Long id);

    Optional<Product> getProductByName(String name);

    Optional<Product> delProduct(Long id);
}
