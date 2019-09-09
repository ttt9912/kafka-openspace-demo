package ch.zuehlke.eventproducer;

import ch.zuehlke.event.ArrivalTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class, args);
    }

    @Bean
    public CommandLineRunner publishBooks(final ArrivalTimeProducer producer) {
        return args -> events().forEach(producer::publish);
    }

    private List<ArrivalTime> events() {
        return Arrays.asList(
                new ArrivalTime("450-1", "Bern", "2019-9-9T12:0:11"),
                new ArrivalTime("450-1", "Bern", "2019-9-9T12:0:11"),
                new ArrivalTime("450-1", "Biel", "2019-9-9T12:0:11"),
                new ArrivalTime("450-1", "Biel", "2019-9-9T12:0:11"),
                new ArrivalTime("450-1", "Bern", "2019-9-9T12:0:11"),

                new ArrivalTime("660-0", "Basel", "2019-9-9T12:0:11"),
                new ArrivalTime("660-0", "Basel", "2019-9-9T12:0:11"),
                new ArrivalTime("660-0", "Basel", "2019-9-9T12:0:11"));
    }

}
