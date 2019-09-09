package ch.zuehlke.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalTime {
    private String trainId;
    private String station;
    private String arrival;

    public String createKey() {
        return trainId + "_" + station;
    }
}