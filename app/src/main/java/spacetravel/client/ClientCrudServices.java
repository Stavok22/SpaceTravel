package spacetravel.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import spacetravel.storage.HibernateServices;

import java.util.List;

public class ClientCrudServices implements ClientService{
    @Override
    public void createNewClient(Client client) throws Exception {
        if (client.getName() == null) {
            throw new NullPointerException("Name can`t be null");
        }
        if (client.getName().length()<3 | client.getName().length()>200){
            throw new Exception ("Name cant be less than 3 and more than 200 characters");
        }
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            System.out.println("New Client added!");
        }
    }

    @Override
    public void deleteClient(Client client) throws Exception {
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client existingClient = session.get(Client.class, client.getId());
            if (client == null) {
                throw new Exception("The client with name " + client.getName() + " does not exists.");
            } else {
                session.remove(existingClient);
                transaction.commit();
                System.out.println("The client with name " + client.getName() + " was deleted.");
            }
        }
    }

    @Override
    public void updateClient(Long id,String name) throws Exception {
        if (name == null){
            throw new Exception("Name cant be null");
        }
        if (name.length()<3 || name.length()>200) {
            throw new Exception("Name must be more than 3 and less than 200 characters");
        }
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Client> queryUpdate = session.createQuery("from Client where id=: id",Client.class);
            queryUpdate.setParameter("id",id);
            Client updateClient = queryUpdate.getSingleResult();
            updateClient.setName(name);
            transaction.commit();
            System.out.println("updateClient"+ updateClient);
        }
    }

    @Override
    public Client getClientByID(Long id) throws Exception {
        Client client;
        if (id <= 0) {
            throw new Exception("Please enter correct Id");
        }
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Query<Client> queryGetById= session.createQuery("from Client where id=:id", Client.class);
            queryGetById.setParameter("id", id);
            client=queryGetById.getSingleResult();
        }

        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients;
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            clients = session.createQuery("from Client", Client.class).list();
            System.out.println("clients = " + clients);
        }
        return clients;
    }
}
