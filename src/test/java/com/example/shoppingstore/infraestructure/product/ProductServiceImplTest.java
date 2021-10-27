//package com.example.shoppingstore.infraestructure.product;
//
//import com.example.shoppingstore.domain.product.*;
//import com.example.shoppingstore.domain.product.ProductFactory;
//
//
//import com.example.shoppingstore.domain.product.ProductRepository;
//
//import com.example.shoppingstore.domain.vendor.Vendor;
//import com.example.shoppingstore.exceptions.ShoppingStoreException;
//import com.example.shoppingstore.web.product.ProductDTO;
//import com.example.shoppingstore.web.product.ProductForm;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.*;
//import org.springframework.data.jpa.domain.Specification;
//
//
//import java.util.List;
//import java.util.Optional;
//
////TODO CHECK AND DEBUG ALL TEST METHODS
//@ExtendWith(MockitoExtension.class)
//class ProductServiceImplTest {
//
//    @Mock
//    private ProductRepository productRepository;
//    @Mock
//    private ProductFactory productFactory;
//    @Mock
//    private ProductForm productForm;
//    @Mock
//    private Page<Product> productPageExpected;
//    @Mock
//    private ShoppingStoreException shoppingStoreException;
//
//    @Captor
//    private ArgumentCaptor<Product> productArgumentCaptor;
//    @Captor
//    private ArgumentCaptor<Optional<Product>> optionalArgumentCaptor;
//
//    ProductServiceImpl productService;
//    Vendor vendor;
//    ProductDTO productDTO;
//    List<Product> productList;
//    Pageable pageable;
//    Specification<Product> productSpecification;
//
//    @BeforeEach
//    void setUp() {
//        productService = new ProductServiceImpl(productRepository,productFactory);
//        Product expectedProduct1 = new Product(1l, "Cars", vendor, 50L);
//        Product expectedProduct2 = new Product(2l, "Rider", vendor, 50L);
//        List<Product> productList = List.of(expectedProduct1, expectedProduct2);
//        vendor = new Vendor(1L, "test name", "test address", productList);
//
//
//        pageable=PageRequest.of(0, 1, Sort.by(
//                Sort.Order.desc("id")));
//        Page page=Page.empty(pageable);
//
//        productDTO = ProductDTO.builder()
//                .name("productDTO test")
//                .idvendor(1L)
//                .price(50L)
//                .build();
//
//        productForm=ProductForm.builder()
//                .id(1L)
//                .idvendor(1L)
//                .name("Cars")
//                .price(50L)
//                .build();
//    }
//    //TODO LEARN HOW TO TEST PAGINATION METHODS
////    @Test
////    @DisplayName("Should list a pageable from products ")
////    void shouldListProducts() {
//////        ProductSpec.listProduct(productForm)
//////        Mockito.when(ProductSpec.listProduct(productForm)).thenReturn(productSpecification);
////        Mockito.when(productRepository.findAll((Example<Product>) Mockito.any(),pageable))
////                .thenReturn(productPageExpected);
////
////        Page<Product> productsPageableActual = productService.listProducts(productForm,pageable);
////        Assertions.assertThat(productsPageableActual).isEqualTo(productPageExpected);
////    }
//
//    @Test
//    @DisplayName("Should to save a product")
//    void shouldSaveProduct() {
//        Product expectedProduct = new Product(1l, "product test", vendor, 50L);
//
//        Mockito.when(productRepository.findByName(productDTO.getName())).thenReturn(Optional.empty());
//        Mockito.when(productFactory.toProduct(productDTO)).thenReturn(expectedProduct);
//        Mockito.when(productRepository.save(expectedProduct)).thenReturn(expectedProduct);
//
//        Product actualProduct = productService.saveProduct(productDTO).get();
//        //Really this way is for void methods, but here we can  use it
//        Mockito.verify(productRepository, Mockito.times(1)).save(productArgumentCaptor.capture());
//        Assertions.assertThat(productArgumentCaptor.getValue().getId()).isEqualTo(expectedProduct.getId());
//    }
//    @Test
//    @DisplayName("Will throw a exception when the product is present")
//    void willThrowWhenProductIsPresent() {
//
//        Product expectedProduct = new Product(1l, "product test", vendor, 50L);
//        ProductDTO productDTOExpected = ProductDTO.builder()
//                .id(1L)
//                .name("productDTO test")
//                .idvendor(1L)
//                .price(50L)
//                .build();
//
//        shoppingStoreException=new ShoppingStoreException("THE PRODUCT ALREADY PERSISTS IN THE DATABASE");
//        Mockito.when(productRepository.findByName(productDTO.getName())).thenReturn(Optional.of(expectedProduct));
//
//        Assertions.assertThatThrownBy(()->productService.saveProduct(productDTOExpected)).hasMessageContaining("THE PRODUCT ALREADY PERSISTS IN THE DATABASE");
//
//        //Really this way is for void methods, but here we can  use it
//
//          }
//
//
//    @Test
//    @DisplayName("Should get product by id")
//    void ShouldGetProductById() {
//        Product expectedProduct = new Product(1l, "Soap", vendor, 50L);
//
//        Mockito.when(productRepository.findById(1L))
//                .thenReturn(Optional.of(expectedProduct));
//        Optional<Product> actualProduct = productService.getProductById(1L);
//
//        Assertions.assertThat(expectedProduct).isEqualTo(actualProduct.get());
//    }
//
//    @Test
//    @DisplayName("Should Update the Product")
//    void shouldUpdateProduct() {
//        Product product = new Product(1L, "product test", vendor, 50L);
//        Product expectedProduct = new Product(5L, "product test", vendor, 50L);
//        ProductDTO productDTOToTes = ProductDTO.builder()
//                .id(5L)
//                .name("productDTO test")
//                .idvendor(1L)
//                .price(50L)
//                .build();
//        System.out.println("aaaaaaaa"+productDTOToTes.getId());
//        Optional<Product> productOptional = Optional.of(product);
//        Long productId = 1L;
//
//        Mockito.when(productRepository.findById(productId))
//                .thenReturn(productOptional);
//        Mockito.when(productFactory.toProductUpdate(productDTOToTes,productOptional.get())).thenReturn(expectedProduct);
//        Optional<Product> actualOptional = productService.updateProduct(productDTOToTes, productId);
//        Assertions.assertThat(actualOptional.get().getId()).isEqualTo(expectedProduct.getId());
//    }
//
//    @Test
//    @DisplayName("Should get a list of product from a vendor id")
//    void shouldGetProductsByVendorId() {
//        Product expectedProduct = new Product(1l, "product test", vendor, 50L);
//        Long vendorId = 1L;
//        Mockito.when(productRepository.findByVendorId(1l)).thenReturn(productList);
//        List<Product> actualListProduct = productService.listProductsByVendorId(vendorId);
//        Assertions.assertThat(actualListProduct).isEqualTo(productList);
//
//    }
//
//    @Test
//    @DisplayName("Should get a product by a name")
//    void getProductByName() {
//        Product expectedProduct = new Product(1l, "Soap", vendor, 50L);
//
//        Mockito.when(productRepository.findByName("Soap"))
//                .thenReturn(Optional.of(expectedProduct));
//        Optional<Product> actualProduct = productService.getProductByName("Soap");
//        Assertions.assertThat(expectedProduct).isEqualTo(actualProduct.get());
//    }
//
//    @Test
//    @DisplayName("Should delete the product ")
//    void ShouldDelProduct() {
//        Product expectedProduct = new Product(1l, "Soap", vendor, 50L);
//        Long productId=1l;
//        Optional<Product> expectedOptional=Optional.of(expectedProduct);
//        Mockito.when(productRepository.findById(productId))
//                .thenReturn(expectedOptional);
//
//        productService.delProduct(productId);
//        Mockito.verify(productRepository,Mockito.times(1)).delete(productArgumentCaptor.capture());
//
//        System.out.println(productArgumentCaptor.getValue());
//        Assertions.assertThat(productArgumentCaptor.getValue().getId()).isEqualTo(expectedProduct.getId());
//        Assertions.assertThat( productRepository.findById(expectedProduct.getId()).isEmpty());
//    }
//
//
////    @AfterEach
////    @Disabled
////    void tearDown() {
////    }
//}