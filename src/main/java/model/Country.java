package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"clubs", "players", "coaches", "matches"})
@ToString(exclude = {"clubs", "players", "coaches", "matches"})
@Builder
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "surface_area")
    private int surfaceArea;
    private int population;
    @Column(name = "iso_code")
    private String isoCode;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Player> players = new HashSet<>();
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Coach> coaches = new HashSet<>();
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Match> matches = new HashSet<>();

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


}
