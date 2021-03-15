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

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + getAge() + ", " + country.getIsoCode() +"), " + club.getName();
    }

    private int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}
