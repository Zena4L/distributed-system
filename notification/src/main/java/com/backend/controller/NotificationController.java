package com.backend.controller;

import com.backend.service.NotificationService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping()
    public void notify(@RequestBody NotifactionRequest  request) {
        notificationService.notify(request);
    }
}
