package com.example.shoppingstore.web.vendor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "vendor")
@EqualsAndHashCode(callSuper = true)
public class VendorModel extends RepresentationModel<VendorModel> {
    private Long id;
    private String name;
    private String address;
    private List<Long> products;

}
