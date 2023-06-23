package spacetravel.ticket;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import spacetravel.client.Client;
import spacetravel.client.ClientCrudServices;
import spacetravel.planet.Planet;
import spacetravel.planet.PlanetCrudService;
import spacetravel.storage.HibernateServices;

import java.util.List;

public class TicketCrudServices implements TicketServices  {
    @Override
    public void createTicket(Ticket ticket) throws Exception {
        if (ticket.getClient()==null) {
            throw new NullPointerException("Client cant be null");
        }
        if (ticket.getFromPlanet()==null) {
            throw new NullPointerException("FromPlanet cant be null");
        }
        if (ticket.getToPlanet()==null) {
            throw new NullPointerException("ToPlanet cant be null");
        }

        Client client = new ClientCrudServices().getClientByID(ticket.getClient().getId());

        if(client==null) {
            throw new NullPointerException("This client does not exist");
        }
        Planet fromPlanet = new PlanetCrudService().getById(ticket.getFromPlanet().getId());

        if (fromPlanet == null) {
            throw new NullPointerException("This fromPlanet does not exist");
        }
        Planet toPlanet = new PlanetCrudService().getById(ticket.getToPlanet().getId());

        if (toPlanet == null) {
            throw new NullPointerException("This toPlanet does not exist");
        }

        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            System.out.println("New ticket added!!!");
        }
    }

    @Override
    public void getTicketById(long id) throws Exception {
        if (id <=0) {
            throw new Exception("Please enter correct ticket Id");
        }
        try( Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Query<Ticket> getQuery = session.createQuery("from Ticket where id= :id", Ticket.class);
            getQuery.setParameter("id", id);
            Ticket ticket = getQuery.getSingleResult();
            System.out.println("Ticket = "+ ticket);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets;
        try (Session session= HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            tickets = session.createQuery("from Ticket",Ticket.class).list();
            System.out.println("tickets = " + tickets);
        }
        return tickets;
    }

    @Override
    public void deleteTicketById(long id) throws Exception {
        if (id <=0) {
            throw new Exception("Please enter correct ticket Id");
        }
        try( Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Ticket> queryDelete = session.createQuery("from Ticket where id= :id",Ticket.class);
            queryDelete.setParameter("id",id);
            Ticket ticketDelete = queryDelete.getSingleResult();
            session.remove(ticketDelete);
            transaction.commit();
            System.out.println("Ticket with id"+ id +" deleted!!!!");
        }
    }

    @Override
    public void modifyTicket(long id, Ticket ticket) throws Exception {
        if (ticket.getClient()==null) {
            throw new NullPointerException("Client cant be null");
        }
        if (ticket.getFromPlanet()==null) {
            throw new NullPointerException("FromPlanet cant be null");
        }
        if (ticket.getToPlanet()==null) {
            throw new NullPointerException("ToPlanet cant be null");
        }

        Client client = new ClientCrudServices().getClientByID(ticket.getClient().getId());

        if(client==null) {
            throw new NullPointerException("This client does not exist");
        }
        Planet fromPlanet = new PlanetCrudService().getById(ticket.getFromPlanet().getId());

        if (fromPlanet == null) {
            throw new NullPointerException("This fromPlanet does not exist");
        }
        Planet toPlanet = new PlanetCrudService().getById(ticket.getToPlanet().getId());

        if (toPlanet == null) {
            throw new NullPointerException("This toPlanet does not exist");
        }
        try (Session session = new HibernateServices().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Ticket> queryModify = session.createQuery("from Ticket where id=:id", Ticket.class);
            queryModify.setParameter("id", id);
            Ticket modifyTicket = queryModify.getSingleResult();
            modifyTicket.setCreated_at(ticket.getCreated_at());
            modifyTicket.setClient(ticket.getClient());
            modifyTicket.setFromPlanet(ticket.getFromPlanet());
            modifyTicket.setToPlanet(ticket.getToPlanet());

            transaction.commit();
            System.out.println("modifyTicket = " + modifyTicket);

        }

    }
}
