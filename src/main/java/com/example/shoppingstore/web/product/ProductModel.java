package com.example.shoppingstore.web.product;

import com.example.shoppingstore.domain.product.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "product")
public class ProductModel extends RepresentationModel<ProductModel> {

    private String name;

    private Long idvendedor;

    private Long precio;


}
