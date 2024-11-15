package tn.foyer.mohamedbenmohamedtpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    //select f from Foyer f where f.nom= ....
    List<Foyer> findByNomFoyer(String nomFoyer);

    //select f from Foyer f where f.nom=.. & f.capacite

    List<Foyer>findByNomFoyerAndCapaciteFoyer(String nomFoyer, long CapaciteFoyer);

    //select f from Foyer f where f.nom=.. || f.prenom
    List<Foyer>findByNomFoyerOrCapaciteFoyer(String nomFoyer, long CapaciteFoyer);

    //select f from Foyer where f.capaciteFoyer between ... and ...
    List<Foyer>getByCapaciteFoyerBetween(long min, long max);

    //select f from Foyer where f.id> ...
    List<Foyer>findByIdFoyerGreaterThan(long idFoyer);

    //select f from Foyer where f.id< ...
    List<Foyer>findByIdFoyerLessThan(long idFoyer);

    //select f from Foyer where f.nom like ...
    List<Foyer>findByNomFoyerLike(String nomFoyer);
    /*List<Foyer>findByNomFoyerContaining(String nomFoyer);
    List<Foyer>findByNomFoyerContains(String nomFoyer);*/

    //Accepte les noms en majuscule et en minuscule
    List<Foyer>findByNomFoyerIgnoreCase(String nomFoyer);
}
