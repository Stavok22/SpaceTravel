package spacetravel.ticket;

import java.util.List;

public interface TicketServices {

    void createTicket(Ticket ticket) throws Exception;
    void getTicketById(long id) throws Exception;
    List<Ticket> getAllTickets();
    void deleteTicketById(long id) throws Exception;
    void modifyTicket(long id,Ticket ticket) throws Exception;
}
