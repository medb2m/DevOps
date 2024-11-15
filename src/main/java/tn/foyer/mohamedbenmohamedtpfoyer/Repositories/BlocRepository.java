package tn.foyer.mohamedbenmohamedtpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    /*//select u from Entity where u.att = ...
    List<Bloc>  findByNomBloc(String nom);
    // select
    // 9
    List<Bloc> getBlocByFoyer(Foyer id_foyer);

    // 10
    List<Bloc> findByFoyerUniversiteIdUniversite(long idUniversite);*/

    // 1-Recherche par nomBloc
    /*List<Bloc> findByNomBloc(String nomBloc);*/
    //Bloc FindByNomBloc(String nomBloc)

    // 2-Recherche par capaciteBloc
    List<Bloc> findByCapaciteBloc(Long capaciteBloc);

    // 3-Recherche par nomBloc et capaciteBloc
    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, Long capaciteBloc);

    // 4-Recherche par nomBloc en ignorant la casse
    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);

    // 5-Recherche par capaciteBloc supérieure à une valeur donnée
    List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc);

    // 6-Recherche par nomBloc contenant une sous-chaîne
    List<Bloc> findByNomBlocContaining(String nomBloc);

    // 7-Tri par nomBloc par ordre alphabétique
    List<Bloc> findAllByOrderByNomBlocAsc();
    //List<Bloc> findByNomBlocOrderBy();

    // 8-Recherche par nomBloc ou capaciteBloc
    List<Bloc> getByNomBlocOrCapaciteBloc(String nomBloc, long capaciteBloc);

    // 9-Recherche du bloc d'un foyer spécifique

    //List<Bloc> findByFIdFoyer(Long IdFoyer);
    @Query("SELECT b FROM Bloc b WHERE b.foyer.idFoyer = :idFoyer")
    List<Bloc> findBlocsByFoyerId(@Param("idFoyer")long IdFoyer);

    // 10-Recherche du bloc pour un foyer d'une université donnée
    //List<Bloc> findByFUIdUniversite(Long universite);
    @Query("SELECT b FROM Bloc b where b.foyer.universite.nomUniversite=:nomUniversite" )
    List<Bloc> findBlocsByUniversiteName(@Param("nomUniversite")String nomUniversite);

    // keyWord
    List<Bloc> findByNomBloc(String nom);
}
