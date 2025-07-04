package com.example.customer_crud.repository;

import com.example.customer_crud.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository {
    private final Map<Long, Customer> customerMap = new HashMap<>();
    private long idCounter = 1;

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(idCounter++);
        }
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    public void deleteById(Long id) {
        customerMap.remove(id);
    }

    public boolean existsById(Long id) {
        return customerMap.containsKey(id);
    }
}

