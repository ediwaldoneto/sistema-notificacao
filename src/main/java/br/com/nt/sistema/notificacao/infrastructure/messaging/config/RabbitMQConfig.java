package br.com.nt.sistema.notificacao.infrastructure.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "notificacoes-exchange";
    public static final String QUEUE_NAME = "notificacoes";
    public static final String ROUTING_KEY = "notificacoes.enviar";

    @Bean
    public Queue notificacoesQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public DirectExchange notificacoesExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(notificacoesQueue())
                .to(notificacoesExchange())
                .with(ROUTING_KEY);
    }

}
