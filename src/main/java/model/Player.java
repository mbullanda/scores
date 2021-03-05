package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"club", "country"})
@ToString(exclude = {"club", "country"})
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private int number;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private int goals;
    private int assists;
    @ManyToOne
    private Club club;
    @ManyToOne
    private Country country;


    public Player(int number, String firstName, String lastName, LocalDate parsedDate, int goals, int assists, Club club, Country country) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = parsedDate;
        this.goals = goals;
        this.assists = assists;
        this.club = club;
        this.country = country;

    }
}
