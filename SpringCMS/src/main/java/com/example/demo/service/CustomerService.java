package com.example.demo.service;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.model.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}