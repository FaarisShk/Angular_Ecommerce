package com.ecommerce.spring_boot_ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.spring_boot_ecommerce.Entity.Customer;

public interface CusomerRepository extends JpaRepository<Customer, Long>{
    
}
