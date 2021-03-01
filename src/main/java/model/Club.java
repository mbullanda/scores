package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "date_of_foundation")
    private LocalDate dateOfFoundation;
    private int trophies;
    @ManyToOne
    private Country country;
    @OneToMany
    private Player player;
    @OneToMany
    private Coach coach;


}
