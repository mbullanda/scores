package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"players", "coaches"})
@ToString(exclude = {"players", "coaches"})
@Builder
@AllArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_foundation")
    private LocalDate dateOfFoundation;
    private int trophies;
    private int points;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Player> players = new HashSet<>();
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Coach> coaches = new HashSet<>();

    public void addPlayer(Player player){
        players.add(player);
        player.setClub(this);
    }
    public void addCoach(Coach coach){
        coaches.add(coach);
        coach.setClub(this);
    }


}
