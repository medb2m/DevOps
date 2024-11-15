package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    long idChambre;

    @Column(nullable = false, unique = true)
    long numeroChambre;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    TypeChambre typeC;

    @ManyToOne
    @JsonIgnore
    Bloc bloc;

    @OneToMany
    List<Reservation> reservations;
}
