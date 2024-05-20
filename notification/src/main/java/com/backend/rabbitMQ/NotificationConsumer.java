package com.backend.rabbitMQ;

import com.backend.controller.NotifactionRequest;
import com.backend.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotifactionRequest notifactionRequest){
        log.info("consumed {} from queue",notifactionRequest);
        notificationService.notify(notifactionRequest);
    }
}
