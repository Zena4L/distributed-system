package com.backend.service;

import com.backend.dto.CustomerRequest;
import com.backend.fraud.FraudCheckResponse;
import com.backend.fraud.FraudClient;
import com.backend.model.Customer;
import com.backend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

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
        repository.saveAndFlush(customer);

        //todo: make a request to fraud service to check


        FraudCheckResponse fraudCheckResponse =  fraudClient.checkFraud(customer.getId());

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification to customers


    }
}
