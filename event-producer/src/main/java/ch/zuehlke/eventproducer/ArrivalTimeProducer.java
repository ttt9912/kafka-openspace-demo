package ch.zuehlke.eventproducer;

import ch.zuehlke.event.ArrivalTime;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArrivalTimeProducer {
    private static final String topic = "arrival-time";

    private final KafkaTemplate<String, ArrivalTime> kafkaTemplate;

    public ArrivalTimeProducer(final KafkaTemplate<String, ArrivalTime> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(final ArrivalTime event) {
        kafkaTemplate.send(topic, event.createKey(), event);
    }
}
