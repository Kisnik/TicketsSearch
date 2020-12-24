package managerPrice;

import manager.TicketManager;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;
import ticket.Ticket;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerByPriceTest {
    private Ticket[] tickets;
    private TicketRepository ticketRepository = new TicketRepository();
    private TicketManager ticketManager = new TicketManager(ticketRepository);
    private Comparator<Ticket> comparator = new Comparator<Ticket>() {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };


    @Test
    public void shouldFindSeveralResults() {
        tickets = new Ticket[6];
        tickets[0] = new Ticket(1, 110, "dme", "led", 90);
        tickets[1] = new Ticket(2, 100, "led", "dme", 88);
        tickets[2] = new Ticket(3, 130, "dme", "vko", 10);
        tickets[3] = new Ticket(4, 150, "dme", "led", 96);
        tickets[4] = new Ticket(5, 100, "led", "dme", 82);
        tickets[5] = new Ticket(6, 98, "dme", "led", 112);

        for (int i = 0; i < 6; i++) {
            ticketRepository.save(tickets[i]);
        }

        Ticket[] actual = ticketManager.findAll("dme", "led", comparator);

        Ticket[] expected = {new Ticket(6, 98, "dme", "led", 112),
                new Ticket(1, 110, "dme", "led", 90),
                new Ticket(4, 150, "dme", "led", 96)};
        assertArrayEquals(expected, actual);
    }
}