package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "surface_area")
    private int surfaceArea;
    private int population;
    @Column(name = "iso_code")
    private String isoCode;
    @OneToMany
    private Club club;
    @OneToMany
    private Player player;
    @OneToMany
    private Coach coach;

}
