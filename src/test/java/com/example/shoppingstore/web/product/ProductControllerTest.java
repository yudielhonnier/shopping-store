package com.example.shoppingstore.web.product;

import com.example.shoppingstore.domain.product.Product;
import com.example.shoppingstore.domain.product.ProductService;
import com.example.shoppingstore.domain.vendor.Address;
import com.example.shoppingstore.domain.vendor.Vendor;
import com.example.shoppingstore.domain.vendor.VendorPKId;
import com.example.shoppingstore.infraestructure.customer.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;


@AutoConfigureMockMvc
@WebMvcTest(controllers = ProductController.class)
//@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerTest {
    @MockBean
    private CustomerServiceImpl customerServiceImpl;
    @MockBean
    private ProductService productService;
    @MockBean
    public ResourceServerTokenServices resourceServerTokenServices;
    @MockBean
    private ProductModelAssembler productModelAssembler;
    @MockBean
    private PagedResourcesAssembler pagedResourcesAssembler;

    private Page<Product> page2;

    private MockMvc mockMvc;
    private VendorPKId vendorPKId;
    private Address address;


    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        Mockito.when(resourceServerTokenServices.loadAuthentication(anyString()))
                .thenAnswer(invocation -> SecurityContextHolder.getContext().getAuthentication());

        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService, productModelAssembler, pagedResourcesAssembler))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .apply(documentationConfiguration( restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .build();

        vendorPKId = VendorPKId.builder()
                .idVendor(2L)
                .name("Lucas")
                .build();

        address = Address.builder()
                .city("New York City")
                .state("New York")
                .street("Jones Street")
                .pincode(10001L)
                .build();
    }

    @Test
    @DisplayName("Should list all the products when mackin Get request to endpoint -/api/v1.0/product/list")
    void shouldListProducts() throws Exception {


        Set<Long> phones = new HashSet<>(List.of(5555555L, 4444444L));
        Vendor vendor = new Vendor(vendorPKId, address, phones, List.of());
        Product expectedProduct1 = new Product(1l, "Cars", vendor, 50L);
        List<Product> productList = List.of(expectedProduct1);
        Page<Product> page2 = new PageImpl(productList);
        given(productService.listProducts(Mockito.any(ProductForm.class), Mockito.any(Pageable.class)))
                .willReturn(page2);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1.0/product/list")
                .content(
                                "{\"id\":\"1\"" +
                                ",\"idVendor\":{\"id\":\"1\"" +
                                              ",\"name\":\"Lucas\"}" +
                                ",\"nameproduct\":\"Cars\"" +
                                ",\"price\":\"50\"}"
                )
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/json"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(""))
                .andDo(document("index",requestFields(
                        fieldWithPath("id").description("Product id"),
                        subsectionWithPath("idVendor").description("Vendor's VendorPKi"),
                        fieldWithPath("nameproduct").description("Product's name"),
                        fieldWithPath("price").description("Product's price")
                )));
//                .andDo(document("index"));
    }

    //TODO TO FINISH THESE  METHODS BELOW
    @Test
    void setProduct() {



    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void delProduct() {
    }

//    @AfterEach
//    void tearDown() {
//    }




}