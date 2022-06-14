package com.example.ecommerce.order.adapter.out.queue;

import com.example.ecommerce.order.adapter.out.queue.converter.OrderMessageConverter;
import com.example.ecommerce.order.adapter.out.queue.message.OrderMessage;
import com.example.ecommerce.order.domain.model.Order;
import com.example.ecommerce.order.port.out.OrderEventDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderDataMessageQueueAdapter implements OrderEventDataProvider {

    @Value("${kafka.template.default-topic}")
    private final String TOPIC;

    private final KafkaTemplate<String, OrderMessage> template;

    @Override
    public void publish(final Order data) {
        if( data == null ){
            return;
        }

        template.send(TOPIC, OrderMessageConverter.from(data));
    }
}
