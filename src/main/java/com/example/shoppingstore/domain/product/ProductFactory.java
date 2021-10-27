package com.example.shoppingstore.domain.product;

import com.example.shoppingstore.domain.vendor.VendorPKIdFactory;
import com.example.shoppingstore.domain.vendor.VendorService;
import com.example.shoppingstore.web.product.ProductDTO;
import com.example.shoppingstore.domain.vendor.Vendor;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {

    @Resource
    private VendorService vendorService;

    @Resource
    private ProductService productService;

    @Resource
    private VendorPKIdFactory vendorPKIdFactory;

    public Product toProduct(ProductDTO productDTO) {
        Vendor recive = vendorService.getVendorByVendorPKId(
                vendorPKIdFactory.toVendorPKIdDTO(productDTO.getVendorPKId()));

        return Product.builder()
                .nameproduct(productDTO.getName())
                .vendor(recive)
                .price(productDTO.getPrice())
                .build();
    }

    public Product toProductUpdate(ProductDTO productDTO, Product product) {
        Vendor recive = vendorService.getVendorByVendorPKId(
                vendorPKIdFactory.toVendorPKIdDTO(productDTO.getVendorPKId()));

        return product.reassamble(
                productDTO.getName()
                , recive
                , productDTO.getPrice()
        );

    }

    //TODO CHECK IF IS A GOOD IDEA MAKE THIS METHOD
    public List<Product> listLongToProduct(List<Long> listLong) {
        return listLong.stream()
                .map(aLong -> productService.getProductById(aLong).get())
                .collect(Collectors.toList());

    }


}
