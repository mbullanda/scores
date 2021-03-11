package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"club", "country"})
@ToString(exclude = {"club", "country"})
@Builder
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return  number + ". " + firstName + " " + lastName +
                " (" + getAge() +
                ", " + country.getIsoCode() +
                "). Goals: " + goals +
                ", assists: " + assists;
    }

    public int getAge(){
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}

