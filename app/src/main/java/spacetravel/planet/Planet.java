package spacetravel.planet;


import jakarta.persistence.*;
import spacetravel.ticket.Ticket;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> departureTickets = new HashSet<>();

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> arrivalTickets = new HashSet<>();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "\n" +
                "{id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
