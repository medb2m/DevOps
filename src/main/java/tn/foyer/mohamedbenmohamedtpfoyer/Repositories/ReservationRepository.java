package tn.foyer.mohamedbenmohamedtpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    // 1- Recherche des réservations validées
    List<Reservation> findByEstValideTrue();

    // 2- Recherche des réservations par l'id de l'étudiant
    List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);

    // 3- Recherche des réservations par année et validité
    List<Reservation> findByAnneeUniversitaireAndEstValide(LocalDate anneeUniversitaire, Boolean estValide);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :currentYear AND r.estValide = true")
    List<Reservation> findReservationsForCurrentYear(@Param("currentYear") LocalDate currentYear);
}
