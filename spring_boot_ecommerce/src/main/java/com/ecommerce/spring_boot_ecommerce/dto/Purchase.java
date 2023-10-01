package com.ecommerce.spring_boot_ecommerce.dto;

import java.util.Set;

import com.ecommerce.spring_boot_ecommerce.Entity.Address;
import com.ecommerce.spring_boot_ecommerce.Entity.Customer;
import com.ecommerce.spring_boot_ecommerce.Entity.Order;
import com.ecommerce.spring_boot_ecommerce.Entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {
    
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
