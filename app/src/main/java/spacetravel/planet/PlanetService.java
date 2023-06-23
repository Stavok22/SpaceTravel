package spacetravel.planet;

import java.util.List;

public interface PlanetService {
    void createPlanet(Planet planet) throws Exception;

    Planet getById(String id);

    void deletePlanet (Planet planet) throws Exception;

    void updatePlanet (String id,String name) throws Exception;

    List<Planet> getAll();
}
