package manager;

import repository.TicketRepository;
import ticket.Ticket;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }


    public Ticket[] findAll(String from, String to) {
        int tmp = 0;
        for (Ticket item : ticketRepository.findAll()) {
            if ((item.getDeparture().equals(from))&&(item.getArrival().equals(to))) {
                tmp++;
            }
        }
        Ticket[] result = new Ticket[tmp];

        int i=0;
        for (Ticket item : ticketRepository.findAll()) {
            if ((item.getDeparture().equals(from))&&(item.getArrival().equals(to))) {
                result[i] = item;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
