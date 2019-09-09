package ch.zuehlke.eventproducer;

import ch.zuehlke.event.ArrivalTime;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArrivalTimeProducer {
    private static final String TOPIC = "arrival-time";

    private final KafkaTemplate<String, ArrivalTime> kafkaTemplate;

    public ArrivalTimeProducer(final KafkaTemplate<String, ArrivalTime> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(final ArrivalTime event) {
        kafkaTemplate.send(TOPIC, event.createKey(), event);
    }
}
