package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
