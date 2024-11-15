package tn.foyer.mohamedbenmohamedtpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Universite;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    // University
    // 10
/*
    List<Universite> getByFoyerBlocsChambreReservationsEtudiantsNomEtContainsAndDateNaissanceBetween(String nom, LocalDate date1, LocalDate date2);
*/
    //1- Afficher la liste des universités qui ont des étudiants dont leurs noms contiennet la chaine
// de caractère en paramètre et leurs dates de naissance entre deux dates passées en paramètre

/*
    List<Universite> findDistinctByFBCRENomEtContainingAndFBCREDateNaissanceBetween(String chaine, LocalDate startDate, LocalDate endDate);
*/
}
