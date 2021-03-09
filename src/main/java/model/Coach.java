package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    public Coach (String firstName, String lastName, LocalDate dateOfBirth, Club club, Country country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.club = club;
        this.country = country;


    }
}
