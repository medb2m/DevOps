package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    long idEtudiant;

    @Column(nullable = false)
    String nomEt;
    @Column(nullable = false)
    String prenomEt;
    @Column(nullable = false, unique = true)
    int cin;
    @Column(nullable = false)
    String ecole;
    @Column(nullable = false)
    LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    List<Reservation> reservations;

}
