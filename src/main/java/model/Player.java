package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private int number;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private int goals;
    private int assists;

    private Club club;

    private Country country;



}
