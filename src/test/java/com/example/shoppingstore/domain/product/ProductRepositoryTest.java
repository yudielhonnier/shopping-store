//package com.example.shoppingstore.domain.product;
//
//
//import com.example.shoppingstore.domain.vendor.Vendor;
//import com.example.shoppingstore.domain.vendor.VendorRepository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
////import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import org.springframework.test.context.jdbc.Sql;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.List;
//
//
////@ActiveProfiles("test")
//@DataJpaTest
//@Testcontainers
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProductRepositoryTest {
//    @Container
//     public  PostgreSQLContainer postgreSQLContainer=new  PostgreSQLContainer("postgres:latest")
//            .withDatabaseName("spring-shopping-test-db")
//            .withUsername("postgres")
//            .withPassword("postgres")
//            ;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private VendorRepository vendorRepository;
////
////    @Autowired
////    private EntityManagerFactory entityManagerFactory;
//
//    private ProductFactory productFactory;
//
//    Vendor vendor2;
//
//    @BeforeEach
//    void setUp() {
//
////        Product expectedProduct1 = new Product(1l, "Cars", vendor2, 50L);
////        Product expectedProduct2 = new Product(2l, "Rider", vendor2, 50L);
////        List<Product> productList = List.of(expectedProduct1, expectedProduct2);
////        vendor2 = new Vendor(1L, "test name", "test address", productList);
//
//
////        vendor2 = new Vendor(2L, "test name", "test address",productsList);
//////        longList = List.of(1L);
////        Product expectedProduct= new Product(1L,"product test",vendor2,50L);
////        List<Product> productsList=List.of(expectedProduct);
//
//
//    }
//
//    @Test
//    void  test(){
//        Assertions.assertThat(postgreSQLContainer.isRunning()).isTrue();
//    }
////
////    @Test
////    @Sql("../../resources/vendor.sql")
////    void shouldSaveProduct() {
////        Product expectedProduct1 = new Product(2l, "Cars", vendor2, 50L);
////        List<Product> productList = List.of(expectedProduct1);
////        vendor2 = new Vendor(2L, "test name", "test address", productList);
////        Vendor vendor3=vendorRepository.save(vendor2);
//////        Product expectedProduct1 = new Product(2l, "Cars", vendor2, 50L);
//////        List<Product> productList = List.of(expectedProduct1);
////
//////        Mockito.when(vendorRepository.save(vendor2)).thenReturn(vendor2);
////
////
//////        Product expectedProduct= new Product(1L,"product test",vendor2,50L);
//////        Product savedProduct=productRepository.save(expectedProduct);
////        Assertions.assertThat(vendor2.getId()).isEqualTo(vendor3.getId());
////
////    }
//
//}
