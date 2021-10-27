//package com.example.shoppingstore.web.product;
//
//import com.example.shoppingstore.domain.product.Product;
//import com.example.shoppingstore.domain.product.ProductService;
//import com.example.shoppingstore.domain.vendor.Vendor;
//import com.example.shoppingstore.infraestructure.customer.CustomerServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.*;
//import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
//import org.springframework.data.web.PagedResourcesAssembler;
//import org.springframework.hateoas.PagedModel;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@AutoConfigureMockMvc
//@WebMvcTest(controllers = ProductController.class )
//class ProductControllerTest {
//    @MockBean
//    private CustomerServiceImpl customerServiceImpl;
//    @MockBean
//    private ProductService productService;
//    @MockBean
//    public ResourceServerTokenServices resourceServerTokenServices;
//    @MockBean
//    private ProductModelAssembler productModelAssembler;
//    @MockBean
//    private PagedResourcesAssembler pagedResourcesAssembler;
//
////    @Autowired
////    private WebApplicationContext webApplicationContext;
//
//
//    private Page<Product> page2;
//
//    private MockMvc mockMvc;
//    private ProductForm productForm;
//    private Pageable pageable;
//
//    @BeforeEach
//    void setUp() {
//        Mockito.when(resourceServerTokenServices.loadAuthentication(anyString()))
//                .thenAnswer(invocation -> SecurityContextHolder.getContext().getAuthentication());
//
//        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService,productModelAssembler,pagedResourcesAssembler))
//                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
//                .build();
//
////    mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
////            .build();
//
//
//    productForm=ProductForm.builder()
//                .id(1L)
//                .idvendor(1L)
//                .name("Cars")
//                .price(50L)
//                .build();
//
//    }
//
//    @Test
//    @DisplayName("Should list all the products when mackin Get request to endpoint -/api/v1.0/product/list")
//    void shouldListProducts() throws Exception {
//        pageable= PageRequest.of(0, 10, Sort.by(
//                Sort.Order.desc("id")));
//
////        Page<Product> pageProduct=Mockito.mock(Page.class);
//        PagedModel<Product> pagedModel=Mockito.mock(PagedModel.class);
//
//
//        Vendor vendor = new Vendor(1L, "test name", "test address", List.of());
//        Product expectedProduct1 = new Product(1l, "Cars", vendor, 50L);
//
//
//
////        given(pagedResourcesAssembler.toModel(page2)).willReturn(pagedModel);
////        given(ResponseEntity.ok().body(pagedModel)).willReturn()
//
////        Mockito.when(productService.listProducts(productForm, pageable)).thenReturn(page2);
//
//
//        List<Product> productList = List.of(expectedProduct1);
//        Page<Product> page2=new PageImpl(productList);
//        given(productService.listProducts(Mockito.any(ProductForm.class), Mockito.any(Pageable.class)))
//                .willReturn(page2);
//
//        mockMvc.perform(MockMvcRequestBuilders
//            .post("/api/v1.0/product/list")
//            .content(
//                    "{\"id\":\"1\",\"idvendor\":\"1\",\"name\":\"Cars\",\"price\":\"50\"}"
//                    )
//            .contentType("application/json")
//            .accept("application/json"))
//            .andExpect(status().is(200));
//           }
//
//
//    @Test
//    void setProduct() {
//    }
//
//    @Test
//    void getProductById() {
//    }
//
//    @Test
//    void updateProduct() {
//    }
//
//    @Test
//    void delProduct() {
//    }
//
////    @AfterEach
////    void tearDown() {
////    }
//
//    //TODO TO READ
//    //    https://github.com/Baeldung/spring-security-oauth/blob/master/oauth-legacy/oauth-resource-server-legacy-1/src/test/java/com/baeldung/live/
//
//}