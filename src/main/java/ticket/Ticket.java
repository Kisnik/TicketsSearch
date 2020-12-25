package ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    @Override
    public int compareTo(Ticket t) {
        return price - t.price;
    }
}
