package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"clubs", "players", "coaches"})
public class Country {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "surface_area")
    private int surfaceArea;
    private int population;
    @Column(name = "iso_code")
    private String isoCode;
    @OneToMany(mappedBy = "country")
    private Set<Club> clubs = new HashSet<>();
    @OneToMany(mappedBy = "country")
    private Set<Player> players = new HashSet<>();
    @OneToMany(mappedBy = "country")
    private Set<Coach> coaches = new HashSet<>();

    public void addClub(Club club) {
        clubs.add(club);
        club.setCountry(this);
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setCountry(this);
    }

    public void addCoach(Coach coach){
        coaches.add(coach);
        coach.setCountry(this);
    }




    public Country (String name, int surfaceArea, int population, String isoCode) {
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.isoCode = isoCode;
    }

}
