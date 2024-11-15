package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Reservation {
    @Id
    String idReservation;

    @Column(nullable = false)
    LocalDate anneeUniversitaire;

    @Column(nullable = false)
    Boolean estValide;

    @ManyToMany
    @JsonIgnore
    List<Etudiant> etudiants;
}
