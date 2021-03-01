package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"players"})
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
    @OneToMany(mappedBy = "club")
    private Set<Player> players = new HashSet<>();
    @OneToOne(mappedBy = "club")
    private Coach coach;

    public Club (String name, LocalDate dateOfFoundation, int trophies, Country country){
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.trophies = trophies;
        this.country = country;
    }


}
