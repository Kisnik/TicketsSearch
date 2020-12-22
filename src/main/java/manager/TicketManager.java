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
        TicketRepository tmp = new TicketRepository();
        for (Ticket item : ticketRepository.findAll()) {
            if (item.getDeparture() == from) {
                if (item.getArrival() == to) {
                    tmp.save(item);
                }
            }
        }
        Arrays.sort(tmp.findAll());
        return tmp.findAll();
    }

}
