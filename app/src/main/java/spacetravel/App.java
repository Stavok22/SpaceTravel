/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package spacetravel;

import spacetravel.client.Client;
import spacetravel.client.ClientCrudServices;
import spacetravel.planet.Planet;
import spacetravel.planet.PlanetCrudService;
import spacetravel.ticket.Ticket;
import spacetravel.ticket.TicketCrudServices;

import java.util.Date;

public class App {


    public static void main(String[] args) throws Exception {
        ClientCrudServices clientCrudServices = new ClientCrudServices();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudServices ticketCrudServices = new TicketCrudServices();

        /* Test ClientCrudServices*/

//       Client client = new Client();
//       client.setName("Jony");
//       client.setId(12L);

//        clientCrudServices.createNewClient(client)
//        clientCrudServices.getAllClients();
//        clientCrudServices.deleteClient(client);
//        clientCrudServices.updateClient(1L,"Tirion");
//        clientCrudServices.getClientByID(5L);


        /*  Test PlanetCrudServices */

//        Planet planet = new Planet();
//        planet.setId("ASTRA9");
//        planet.setName("Astra");

//        planetCrudService.getAll();
//        planetCrudService.createPlanet(planet);
//        planetCrudService.deletePlanet(planet);
//        planetCrudService.updatePlanet("EARTH3","EarthNew");
//        planetCrudService.getById("EARTH3");




        /*  Test PlanetCrudServices */

//        Ticket ticket = new Ticket();
//        ticket.setCreated_at(new Date());
//        ticket.setClient(new ClientCrudServices().getClientByID(8L));
//        ticket.setFromPlanet(new PlanetCrudService().getById("MARS4"));
//        ticket.setToPlanet(new PlanetCrudService().getById("URAN5"));

//        new TicketCrudServices().createTicket(ticket);

//        Ticket modifyTicket = new Ticket();
//        modifyTicket.setCreated_at(new Date());
//        modifyTicket.setClient(new ClientCrudServices().getClientByID(2L));
//        modifyTicket.setFromPlanet(new PlanetCrudService().getById("URAN5"));
//        modifyTicket.setToPlanet(new PlanetCrudService().getById("MARS4"));
//
//        ticketCrudServices.modifyTicket(1L,modifyTicket);


        ticketCrudServices.getAllTickets();
//        ticketCrudServices.deleteTicketById(12L);
//        ticketCrudServices.getTicketById(9L);

    }
}