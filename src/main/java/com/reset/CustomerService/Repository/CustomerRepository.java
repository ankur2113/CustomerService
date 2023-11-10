package com.reset.CustomerService.Repository;

import com.reset.CustomerService.Entity.CustomerCart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<CustomerCart, Long> {
}
