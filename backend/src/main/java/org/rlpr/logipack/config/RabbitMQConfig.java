package org.rlpr.logipack.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    // CONTEXT METHODS

    @Value("${rabbitmq.queues.encomendas}")
    private String queueEncomendas;

    @Value("${rabbitmq.queues.transportadores}")
    private String queueTransportadores;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.keys.encomendas}")
    private String routingKeyEncomendas;

    @Value("${rabbitmq.routing.keys.transportadores}")
    private String routingKeyTransportadores;



    //QUEUES

    @Bean
    public Queue queueEncomendas(){
        return new Queue(queueEncomendas, false);
    }

    @Bean
    public Queue queueTransportadores(){
        return new Queue(queueTransportadores, false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }



    // binding between queue and exchange using routing key

    @Bean
    public Binding bindingEncomendas(){
        return BindingBuilder
            .bind(queueEncomendas())
            .to(exchange())
            .with(routingKeyEncomendas);
    }

    @Bean
    public Binding jsonBinding(){
        return BindingBuilder
            .bind(queueTransportadores())
            .to(exchange())
            .with(routingKeyTransportadores);
    }

}
