package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

public interface IBlocService {
    Bloc add(Bloc bloc);
    List<Bloc> addAll(List<Bloc> blocs);
    Bloc update(Bloc bloc);
    List<Bloc> updateAll(List<Bloc> blocs);
    Bloc selectById(long id);
    List<Bloc> selectAll();
    void delete(Bloc bloc);
    void deleteById(long id);
    void deleteAll(List<Bloc> blocs);
    void deleteAll();
    long compter();

    List<Bloc> jibByNomm(String nom);
    /*List<Bloc> getBlocByFoyer(Foyer id);
    List<Bloc> get10(long id);*/

    List<Bloc> findBlocsByFoyerId(Long IdFoyer);

    // affecter bloc à un foyer
    Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);

    Bloc ajouterBlocETSesChambres(Bloc b);

    Bloc ajouterBlocETAffecterAfoyer(Bloc bloc, String nomFoyer);

    void deleteBloc(long idBloc);

    void affichequlqchose();
}
