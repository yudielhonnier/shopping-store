//package com.example.shoppingstore.domain.product;
//
//import com.example.shoppingstore.domain.vendor.Vendor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@ActiveProfiles("test")
//class ProductRepositoryTestEmbedded {
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    private ProductFactory productFactory;
////    List<Long> longList;
//    Vendor vendor2;
//
//
//    @BeforeEach
//    void setUp() {
////
////        longList = List.of(1L);
//        Product expectedProduct= new Product(1L,"product test",vendor2,50L);
//        List<Product> productsList=List.of(expectedProduct);
//        vendor2 = new Vendor(2L, "test name", "test address",productsList);
//
//    }
//
//    @Test
//    void shouldSaveProduct() {
//        Product expectedProduct= new Product(1L,"product test",vendor2,50L);
//    Product savedProduct=productRepository.save(expectedProduct);
//    assertThat(savedProduct).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedProduct);
//
//}
//
//
////    @AfterEach
////    void tearDown() {
////    }
//}