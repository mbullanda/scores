package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"club", "country", "matches"})
@ToString(exclude = {"club", "country", "matches"})
@Builder
@AllArgsConstructor
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToOne
    private Club club;
    @ManyToOne
    private Country country;
    @ManyToMany(mappedBy = "coaches", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Match> matches = new HashSet<>();

    public void addMatch(Match match){
        matches.add(match);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + getAge() + ", " + country.getIsoCode() +")";
    }

    private int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}
