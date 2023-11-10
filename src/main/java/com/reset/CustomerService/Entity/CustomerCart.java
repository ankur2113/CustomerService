package com.reset.CustomerService.Entity;

import com.reset.CustomerService.DTO.CartDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "customer_table")
public class CustomerCart {

    @Id
    private Long customerId;
    private String customerName;
    private CartDTO cart;
    private Long cartId;

}
