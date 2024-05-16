package com.backend.service;

import com.backend.dto.CustomerRequest;
import com.backend.model.Customer;
import com.backend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public void register(CustomerRequest request) {


        Customer customer = Customer.builder()
                .firstName(request.firstname())
                .lastName(request.lastname())
                .email(request.email())
                .build();

        //todo: check if email is valid
        // todo:  check if email is not taken
        // todo : store customer in a database
        // todo: send notification to customers

        repository.save(customer);
    }
}
