package com.reset.CustomerService.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItemDTO {
    private ProductDTO product;
    private int quantity;
}
