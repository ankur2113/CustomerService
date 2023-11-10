package com.reset.CustomerService.Controller;

import com.reset.CustomerService.Entity.CustomerCart;
import com.reset.CustomerService.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/createCartForCustomer")
    public Mono<ResponseEntity<CustomerCart>> createCartForCustomer(@RequestBody CustomerCart customerCart) {
        return customerService.createCartForCustomer(customerCart)
                .map(createdCart -> ResponseEntity.ok().body(createdCart))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

}
