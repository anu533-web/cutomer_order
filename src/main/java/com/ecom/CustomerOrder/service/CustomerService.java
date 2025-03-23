package com.ecom.CustomerOrder.service;




import com.ecom.CustomerOrder.Exception.ResourceNotFoundException;
import com.ecom.CustomerOrder.model.Customer;
import com.ecom.CustomerOrder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository Repository;

    public List<Customer> getAllCustomers() {
        return Repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public Customer addCustomer(Customer customer) {
        return Repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Repository.deleteById(id);
    }
}

