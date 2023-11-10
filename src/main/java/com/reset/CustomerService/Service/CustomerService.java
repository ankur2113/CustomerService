package com.reset.CustomerService.Service;

import com.reset.CustomerService.DTO.CartDTO;
import com.reset.CustomerService.Entity.CustomerCart;
import com.reset.CustomerService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final WebClient.Builder webClientBuilder;
    private final String cartServiceBaseUrl;

    public CustomerService(WebClient.Builder webClientBuilder, CustomerRepository customerRepository, @Value("${cartservice.baseurl}") String cartServiceBaseUrl) {
        this.webClientBuilder = webClientBuilder;
        this.customerRepository = customerRepository;
        this.cartServiceBaseUrl = cartServiceBaseUrl;
    }

    public Mono<CustomerCart> createCartForCustomer(CustomerCart customerCart) {
        customerCart.setCartId(customerCart.getCartId());

        WebClient webClient = webClientBuilder.baseUrl(cartServiceBaseUrl).build();
        // Communicate with CartService to create/update the cart
        return webClient.post()
                .uri("/createcart")
                .bodyValue(customerCart.getCart()) // Assuming CartDTO is the expected payload for CartService
                .retrieve()
                .bodyToMono(CartDTO.class) // Assuming CartService returns a CartDTO
                .map(cartDTO -> {
                    customerCart.setCart(cartDTO); // Update the customerCart with the new cart details
                    return customerCart;
                })
                .flatMap(this::saveCustomerCart);
    }


    private Mono<CustomerCart> saveCustomerCart(CustomerCart customerCart) {
        // Implement the logic to save the CustomerCart in the repository
        return customerRepository.save(customerCart);
    }
}
