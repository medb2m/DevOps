package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    long idFoyer;

    @Column(nullable = false)
    String nomFoyer; //nomFoyer

    @Column(nullable = false)
    long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    Universite universite;

    @OneToMany(mappedBy = "foyer")
    List<Bloc> blocs;
}
