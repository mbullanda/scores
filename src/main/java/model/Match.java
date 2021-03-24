package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"clubs","players","coaches"})
@ToString(exclude = {"clubs","players","coaches"})
@Builder
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "clubs_in_match",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "players_in_match",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    @Builder.Default
    private Set<Player> players = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "coaches_in_match",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    @Builder.Default
    private Set<Coach> coaches = new HashSet<>();
    @Column(name = "home_goals")
    private int homeGoals;
    @Column(name = "away_goals")
    private int awayGoals;
    private LocalDate date;
    @ManyToOne
    private Country country;

    public void addClub(Club club) {
        clubs.add(club);
        club.addMatch(this);
    }

    public void addPlayer(Player player){
        players.add(player);
        player.addMatch(this);
    }

    public void addCoach(Coach coach){
        coaches.add(coach);
        coach.addMatch(this);
    }

}
