package spacetravel.storage;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void initDb() {
        String connectionUrl= "jdbc:h2:./space_travel";
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl,null,null)
                .load();

        flyway.migrate();
    }

    public static void main(String[] args) {
        new DatabaseInitService().initDb();
    }
}
