package com.scalable.notifications.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentConfirmedListener {

    private static final Logger log = LoggerFactory.getLogger(EnrollmentConfirmedListener.class);

    @RabbitListener(queues = "notification.queue")
    public void handle(EnrollmentConfirmedEvent event) {
        log.info("[EMAIL STUB] studentId={} enrollmentId={} sectionId={} amount={}",
                event.studentId(), event.enrollmentId(), event.sectionId(), event.amount());
    }
}
