package spacetravel.planet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import spacetravel.storage.HibernateServices;

import java.util.List;

public class PlanetCrudService implements PlanetService{
    @Override
    public void createPlanet(Planet planet) throws Exception {
        if (!planet.getId().matches("^[A-Z0-9]*$")) {
            throw new Exception("Id must contain only uppercase letters and numbers");
        }
        if (planet.getName().length()>500) {
            throw new Exception("name must be less than 500 characters");
        }
        if (planet.getName()==null) {
            throw new NullPointerException("Name can`t be null");
        }
        if (planet.getId()==null) {
            throw new NullPointerException("Id can`t be null");
        }
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
            System.out.println("New Planet Created!!!");
        }
    }

    @Override
    public Planet getById(String id) {
        Planet planet;
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()){
            Query<Planet> queryGetById= session.createQuery("from Planet where id=:id", Planet.class);
            queryGetById.setParameter("id",id);
            planet=queryGetById.getSingleResult();
        }
        System.out.println(planet);
        return planet;
    }

    @Override
    public void deletePlanet(Planet planet) throws Exception {
        try(Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction= session.beginTransaction();
            Planet existingPlanet = session.get(Planet.class,planet.getId());
            if (planet == null) {
                throw new Exception("The planet with name "+ planet.getName()+" does not exist");
            } else {
                session.remove(existingPlanet);
                transaction.commit();
                System.out.println("The Planet with name "+planet.getName()+" was deleted!!!");
            }
        }
    }

    @Override
    public void updatePlanet(String id, String name) throws Exception {
        if(!id.matches("^[A-Z0-9]*$")){
            throw new Exception("Id  must contain only uppercase letters and numbers");
        }

        if (name == null) {
            throw new NullPointerException("Name can't be null");
        }

        if (name.length()>500){
            throw new Exception("Name must be less than 500 characters");
        }
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Planet> queryModify= session.createQuery("from Planet where id=:id", Planet.class);
            queryModify.setParameter("id", id);
            Planet modifyPlanet = queryModify.getSingleResult();
            modifyPlanet.setName(name);
            transaction.commit();
            System.out.println("modifyPlanet = " + modifyPlanet);
        }
    }

    @Override
    public List<Planet> getAll() {
        List<Planet> planets;
        try (Session session = HibernateServices.getINSTANCE().getSessionFactory().openSession()) {
            planets = session.createQuery("from Planet", Planet.class).list();
            System.out.println("planets = " + planets);
        }
        return planets;
    }
}
