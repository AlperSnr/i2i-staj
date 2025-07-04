package com.example.customer_crud.dto;

import com.example.customer_crud.model.Customer;

public class CustomerMapper {
    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
    }

    public static Customer toEntity(CustomerDTO dto) {
        return new Customer(dto.getId(), dto.getName(), dto.getEmail());
    }
}
