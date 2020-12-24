package manager;

import repository.TicketRepository;
import ticket.Ticket;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }


    public Ticket[] findAll(String from, String to) {
        TicketRepository tmp = new TicketRepository();
        for (Ticket item : ticketRepository.findAll()) {
            if (item.getDeparture().equals(from)) {
                if (item.getArrival().equals(to)) {
                    tmp.save(item);
                }
            }
        }
        Arrays.sort(tmp.findAll());
        return tmp.findAll();
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        TicketRepository tmp = new TicketRepository();
        for (Ticket item : ticketRepository.findAll()) {
            if (item.getDeparture().equals(from)) {
                if (item.getArrival().equals(to)) {
                    tmp.save(item);
                }
            }
        }
        Arrays.sort(tmp.findAll(), comparator);
        return tmp.findAll();
    }

}
