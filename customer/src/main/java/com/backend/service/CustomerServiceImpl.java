package com.backend.service;

import com.backend.dto.CustomerRequest;
import com.clement.fraud.FraudCheckResponse;
import com.clement.fraud.FraudClient;
import com.clement.notification.NotifactionRequest;
import com.clement.notification.NotificationClient;
import com.backend.model.Customer;
import com.backend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    //    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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


        FraudCheckResponse fraudCheckResponse = fraudClient.checkFraud(customer.getId());

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        NotifactionRequest request1 = NotifactionRequest.builder()
                .customerId(String.valueOf(customer.getId()))
                .customerEmail(customer.getEmail())
                .sender("Clement")
                .message("fraud checked")
                .build();

        //todo : make it async with message
        notificationClient.notify(request1);


    }
}
