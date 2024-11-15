package tn.foyer.mohamedbenmohamedtpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.TypeChambre;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    // 1- Recherche par numéro de chambre
    Chambre findByNumeroChambre(long numeroChambre);

    // 2- Recherche par type de chambre
    List<Chambre> findByTypeC(TypeChambre typeC);

    // 3- Recherche des chambres par bloc
    List<Chambre> findByBlocIdBloc(long idBloc);

    // 4- Recherche des chambres par bloc et type de chambre
    List<Chambre> findByBlocIdBlocAndTypeC(long Bloc, TypeChambre typeC);

    // 5- Recherche des chambres par numéro de chambre et type de chambre
    Chambre findByNumeroChambreAndTypeC(long numeroChambre, TypeChambre typeC);

    // 6- Récupérer des chambres en filtrant par le nom de l'université associée au foyer,
    // l'année de réservation, le nom de l'étudiant dans la réservation et le numéro de chambre
    //List<Chambre> findByBFUNomUniversiteAndRAnneeUniversitaireAndRENomEtAndNumeroChambre(String nomUniversite, LocalDate anneeUniversitaire, String nomEtudiant, Long numeroChambre);
    @Query(value = "SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "JOIN c.reservations r " +
            "JOIN r.etudiants e " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND r.anneeUniversitaire = :anneeUniversitaire " +
            "AND e.nomEt = :nomEtudiant " +
            "AND c.numeroChambre = :numeroChambre")
    List<Chambre> findChambresByUniversiteAnneeEtudiantNumeroChambre(
            String nomUniversite,
            LocalDate anneeUniversitaire,
            String nomEtudiant,
            long numeroChambre
    );

    List<Chambre> findByBlocNomBlocContaining(String nomBloc);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.nomBloc LIKE %:nomBloc%")
    List<Chambre> findChambresByNomBlocJPQL(@Param("nomBloc") String nomBloc);

    @Query(value = "SELECT * FROM Chambre c JOIN Bloc b ON c.bloc_id_bloc = b.id_bloc WHERE b.nom_bloc LIKE %:nomBloc%", nativeQuery = true)
    List<Chambre> findChambresByNomBlocSQL(@Param("nomBloc") String nomBloc);
}
