package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    long idUniversite;

    @Column(nullable = false)
    String nomUniversite;
    @Column(nullable = false)
    String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    Foyer foyer;
}
