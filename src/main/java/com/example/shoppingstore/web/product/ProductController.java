package com.example.shoppingstore.web.product;


import com.example.shoppingstore.domain.product.Product;
import com.example.shoppingstore.domain.product.ProductService;
import com.example.shoppingstore.infraestructure.utils.HeaderUtil;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


//TODO IMPLEMENT CONTROLLER INHERENCE

//TODO READ ABOUT REQUEST AND RESPONSES OBJECTS JSON

@RestController
@RequestMapping(path = ProductController.ENTITY_API + ProductController.ENTITY_URI)
@RequiredArgsConstructor
public class ProductController {

    protected static final String ENTITY_API = "api/v1.0";
    protected static final String ENTITY_URI = "/product";

    private final @NotNull
    ProductService productService;
    private final @NotNull
    ProductModelAssembler productModelAssembler;
    private final @NotNull
    PagedResourcesAssembler pagedResourcesAssembler;


    //TODO READ MORE ABOUT SPECIALIZATIONS
    //TODO AND TO FINISH LIST PRODUCT SPECIALIZATIONS
    //TODO ADD VALIDATIONS
    @RequestMapping(path = "/list", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<PagedModel<Product>> listProducts(@RequestBody ProductForm productForm, Pageable pageable) {
        Page<Product> pageProduct = productService.listProducts(productForm, pageable);

        if (pageProduct.isEmpty()) {
            //TODO FIX HEADER UTIL
            return ResponseEntity.ok()
                    .headers(HeaderUtil.badRequestAlert("product.list.error.page-isempty"))
                    .body(pagedResourcesAssembler.toModel(pageProduct));
        }

        return ResponseEntity.ok()
                .headers(HeaderUtil.infoAlert("product.list.successs"))
                .body(pagedResourcesAssembler.toModel(pageProduct));
    }

    //TODO FIX THE PROBLEM SAVING THE PRODUCT
    @RequestMapping(path = "/set", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ProductModel> setProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        Optional<Product> optionalProduct = productService.saveProduct(productDTO);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.ok()
                    .headers(HeaderUtil.badRequestAlert("product.post.error"))
                    .body(productModelAssembler.toModel(optionalProduct.get()));

        }
        return ResponseEntity.created(new URI(ENTITY_API + ENTITY_URI + productDTO.getId()))
                .headers(HeaderUtil.infoAlert("product.post.success"))
                .body(productModelAssembler.toModel(optionalProduct.get()));

    }

    @RequestMapping(path = "/{productId}", method = RequestMethod.GET)
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long productId) {
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isEmpty()) {

            return ResponseEntity.ok()
                    .headers(HeaderUtil.badRequestAlert("product.get.error"))
                    .body(productModelAssembler.toModel(optionalProduct.get()));
        }
        return ResponseEntity.ok()
                .headers(HeaderUtil.infoAlert("product.get.successs"))
                .body(productModelAssembler.toModel(optionalProduct.get()));
    }


    @RequestMapping(path = "/set", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        Optional<Product> product = productService.updateProduct(productDTO, id);

        //TODO SEE THE WAY TO CAPTURE ALL THE PARAMETERS OF A INSTANCE

        if (product.isPresent()) {
            return ResponseEntity.ok()
                    .headers(HeaderUtil.badRequestAlert("product.get.successs"))
                    .body(productModelAssembler.toModel(product.get()));
        } else {
            return ResponseEntity.ok()
                    .headers(HeaderUtil.infoAlert("product.get.error.id-not-result"))
                    .body(productModelAssembler.toModel(product.get()));
        }
    }


    @RequestMapping(path = "/{productId}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity<ProductModel> delProduct(@PathVariable Long productId) {
        Optional<Product> deletedProduct = productService.delProduct(productId);
        if (deletedProduct.isPresent()) {
            return ResponseEntity.ok()
                    .headers(HeaderUtil.badRequestAlert("product.del.successs"))
                    .body(productModelAssembler.toModel(deletedProduct.get()));
        } else {
            return ResponseEntity.ok()
                    .headers(HeaderUtil.infoAlert("product.del.error.id-not-result"))
                    .body(productModelAssembler.toModel(deletedProduct.get()));
        }
    }


}
