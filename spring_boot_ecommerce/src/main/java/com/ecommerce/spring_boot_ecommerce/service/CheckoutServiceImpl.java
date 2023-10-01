package com.ecommerce.spring_boot_ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.spring_boot_ecommerce.Entity.Customer;
import com.ecommerce.spring_boot_ecommerce.Entity.Order;
import com.ecommerce.spring_boot_ecommerce.Entity.OrderItem;
import com.ecommerce.spring_boot_ecommerce.dao.CusomerRepository;
import com.ecommerce.spring_boot_ecommerce.dto.Purchase;
import com.ecommerce.spring_boot_ecommerce.dto.PurchaseResponse;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CusomerRepository customerRepository;
    
    public CheckoutServiceImpl(CusomerRepository cusomerRepository){
        this.customerRepository = cusomerRepository;
    }
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
    
     private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
    
}
