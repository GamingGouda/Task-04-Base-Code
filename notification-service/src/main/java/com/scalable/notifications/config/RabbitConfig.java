package com.scalable.notifications.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME  = "enrollments.exchange";
    public static final String QUEUE_NAME     = "notification.queue";
    public static final String ROUTING_KEY    = "enrollment.confirmed";

    @Bean
    public TopicExchange enrollmentsExchange() {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange enrollmentsExchange) {
        return BindingBuilder.bind(notificationQueue).to(enrollmentsExchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
