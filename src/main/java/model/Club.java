package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"players", "coaches", "matches"})
@ToString(exclude = {"players", "coaches", "matches"})
@Builder
@AllArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_foundation")
    private LocalDate dateOfFoundation;
    private int points;
    private int trophies;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Player> players = new HashSet<>();
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Coach> coaches = new HashSet<>();
    @ManyToMany(mappedBy = "clubs", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Match> matches = new HashSet<>();

    public void addPlayer(Player player){
        players.add(player);
        player.setClub(this);
    }
    public void addCoach(Coach coach){
        coaches.add(coach);
        coach.setClub(this);
    }
    public void addMatch(Match match){
        matches.add(match);
    }

    public void addPoints(int result){
        if (result == 1){
            this.points = getPoints() + 1;
        } else if (result == 3){
            this.points = getPoints() + 3;
        }
    }


}
