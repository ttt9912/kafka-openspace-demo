package ch.zuehlke.eventconsumer;

import ch.zuehlke.event.ArrivalTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArrivalTimeConsumer {
    private static final String topic = "arrival-time";

    @KafkaListener(topics = topic, containerFactory = "kafkaListenerContainerFactory")
    public void bookListener(ConsumerRecord<String, ArrivalTime> record) {
        log.info(">>> key={}, value={}, partition={}, offset={}", record.key(), record.value(), record.partition(), record.offset());
    }

}
