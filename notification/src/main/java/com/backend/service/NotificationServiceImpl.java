package com.backend.service;

import com.backend.controller.NotifactionRequest;
import com.backend.model.Notification;
import com.backend.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;

    @Override
    public void notify(NotifactionRequest request) {

        Notification notification = Notification.builder()
                .message(request.message())
                .customerId(request.customerId())
                .customerEmail(request.customerEmail())
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(notification);

        log.info("fraud check on customerId {}", notification.getCustomerId());
    }
}
