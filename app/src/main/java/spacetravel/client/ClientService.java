package spacetravel.client;

import java.util.List;

public interface ClientService {
    void createNewClient(Client client) throws Exception;

    void deleteClient(Client client) throws Exception;
    void updateClient(Long id,String name) throws Exception;
    Client getClientByID(Long id) throws Exception;
    List<Client> getAllClients();
}
