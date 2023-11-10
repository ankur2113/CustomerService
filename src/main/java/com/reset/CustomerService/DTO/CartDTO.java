package com.reset.CustomerService.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDTO {

    private Long cartId;
    private List<CartItemDTO> items;
    private double totalPrice;

}
