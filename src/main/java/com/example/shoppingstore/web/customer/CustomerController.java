package com.example.shoppingstore.web.customer;


import com.example.shoppingstore.domain.customer.Customer;
import com.example.shoppingstore.domain.customer.CustomerRepository;
import com.example.shoppingstore.domain.customer.CustomerService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


//TODO FIX NO SEND PASSWORD BY JSON
@RestController
@RequestMapping(path = CustomerController.ENTITY_API + CustomerController.ENTITY_URI)
@PreAuthorize("!hasRole('USER')")
@RequiredArgsConstructor
public class CustomerController {

    protected static final String ENTITY_API = "api/v1.0";
    protected static final String ENTITY_URI = "/customer";

    @Resource
    CustomerRepository customerRepository;

    private final @NotNull
    CustomerService customerService;

    private final @NotNull
    PasswordEncoder passwordEncoder;

    private final @NotNull
    CustomerModelAssembler customerModelAssembler;

    private final @NotNull
    PagedResourcesAssembler<Customer> pagedResourcesAssembler;


    //    @GetMapping()
//    ResponseEntity<PagedModel<CustomerModel>> all() {
//        Pageable pageable1 = PageRequest.of(0, 1, Sort.by(
//                Sort.Order.desc("id")));
//        //TODO THIS PART TO GO TO THE USERSERVICE
//        Page<Customer> page = customerRepository.findAll(pageable1);
//        PagedModel<CustomerModel> pagedModel = pagedResourcesAssembler.toModel(page, customerModelAssembler);
//        return ResponseEntity.ok(pagedModel);
//    }
//
    @GetMapping("{id}")
    ResponseEntity<CustomerModel> searchUserById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customerModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    //TODO  ADD VALIDATIONS
//    //TODO TO TRANSFORM PAGE CUSTOMER TO PAGEMODEL
//    @GetMapping("/pageable/{id}")
//    ResponseEntity<Page<Customer>> searchUserPageableById(@PathVariable Long id, Pageable pageable) {
//        Page<Customer> page = customerRepository.getAllById(id, pageable);
//        if (page != null)
//            return ResponseEntity.ok(page);
//        else return ResponseEntity.notFound().build();
//    }
//
//
//    //TODO MAKE A SERVICE FOR THIS
//    @PutMapping("{email}")
//    void putUserByEmail(@RequestBody @Valid Customer customer, @PathVariable String email) {
//        Optional<Customer> obt = customerRepository.findByEmail(email);
//        if (obt.isPresent()) {
//            Customer update = obt.get();
//            update.setPassword(passwordEncoder.encode(customer.getPassword()));
//            update.setId(customer.getId());
//            update.setRole(customer.getRole());
//            update.setEmail(customer.getEmail());
//            customerRepository.save(update);
//        } else
//            customerRepository.save(customer);
//    }


    @PostMapping
    ResponseEntity<?> postUser(@RequestBody @Valid CustomerDTO customerDTO) {

        Customer customer = customerService.save(customerDTO);
        return ResponseEntity.ok(customer);
    }


//    @DeleteMapping("{email}")
//    ResponseEntity<?> deleteUser(@PathVariable String email, OAuth2Authentication oAuth2Authentication) throws Exception {
//        String actual = oAuth2Authentication.getUserAuthentication().getPrincipal().toString();
//        if (!actual.equals(email)) {
//            Optional<Customer> optionalUsersss = customerRepository.findByEmail(email);
//            if (!optionalUsersss.isPresent()) {
//                throw new Exception();
//            }
//            Customer todelete = optionalUsersss.get();
//            customerRepository.delete(todelete);
//            return ResponseEntity.ok(todelete);
//        } else {
//            throw new RuntimeException("THE ACCOUNT IS IN USE");
//        }
//    }
//
//
//    @GetMapping("/search")
//    Page<Customer> searchUser(@RequestParam String email, Pageable pageable, OAuth2Authentication authentication) {
//        String auth = (String) authentication.getUserAuthentication().getPrincipal();
//        String role = authentication.getAuthorities().iterator().next().getAuthority();
//        if (role.equals(Customer.Role.USER.name())) {
//            return customerRepository.findAllByEmailContainsAndEmail(email, auth, pageable);
//        }
//        return customerRepository.findByEmailContains(email, pageable);
//    }
//
//
//
//    @GetMapping("/whoami")
//    public String whoami(@AuthenticationPrincipal(expression="username") String name) {
//        return name;
//    }

}
