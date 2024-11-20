package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.BlocRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.ChambreRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.FoyerRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Universite;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class BlocService implements IBlocService {

    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
    ChambreRepository chambreRepository;
    @Override
    public Bloc add(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> addAll(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc update(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> updateAll(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc selectById(long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public List<Bloc> selectAll() {
        return blocRepository.findAll();
    }

    @Override
    public void delete(Bloc bloc) {
        blocRepository.delete(bloc);
    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Bloc> blocs) {
        blocRepository.deleteAll();
    }

    @Override
    public void deleteAll() {
        blocRepository.deleteAll();
    }

    @Override
    public long count() {
        return blocRepository.count();
    }

    @Override
    public List<Bloc> jibByNomm(String nom) {
        return blocRepository.findByNomBloc(nom);
    }


    @Override
    public List<Bloc> findBlocsByFoyerId(Long IdFoyer) {
        return blocRepository.findBlocsByFoyerId(IdFoyer);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc).get(1);
        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer).get(1);
        // on affecte le child au parent
        bloc.setFoyer(foyer);
        return blocRepository.save(bloc);
    }


    ChambreRepository chambreRepo;
    @Override
    public Bloc ajouterBlocETSesChambres(Bloc b) {

        Bloc savedBloc = blocRepository.save(b);
        for (Chambre chambre : b.getChambre()){
            chambre.setBloc(b);
            chambreRepo.save(chambre);
        }

        return savedBloc;
    }

    @Override
    public Bloc ajouterBlocETAffecterAfoyer(Bloc bloc, String nomFoyer) {
        List<Foyer> f = foyerRepository.findByNomFoyer(nomFoyer);
        if (f.isEmpty()) {
            throw new IllegalArgumentException("Foyer with name " + nomFoyer + " not found.");
        }
        bloc.setFoyer(f.get(0));
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(long idBloc) {
        Bloc b = blocRepository.findById(idBloc).get();
        chambreRepository.deleteAll(b.getChambre());
        blocRepository.delete(b);
    }

    @Override
    public void affichequlqchose() {

    }

    @Scheduled(cron = "0 * * * * *")
    void listeChambreParBloc(){
        // ce service ce declenche chaque minute permettant d'afficher la liste des chambres du bloc en respectant
        // la signature suivante dans la console
        // Bloc => A ayant une capacité 70
        // la liste de chambres pour ce bloc :
        // NumChambre : 1 , type : SINGLE
        // et si pas de chambres dans le bloc on ecrit pas de chambre disponible dans ce bloc

        // Récupérer tous les blocs
        List<Bloc> blocs = blocRepository.findAll();

        // Parcourir chaque bloc et afficher les détails
        for (Bloc bloc : blocs) {
            log.info("Bloc => {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());

            // Vérifier si le bloc contient des chambres
            List<Chambre> chambres = bloc.getChambre();
            if (chambres == null || chambres.isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                log.info("La liste de chambres pour ce bloc :");
                // Parcourir les chambres et afficher leurs informations
                for (Chambre chambre : chambres) {
                    log.info("NumChambre : {}, type : {}", chambre.getNumeroChambre(), chambre.getTypeC());
                }
            }
        }
    }

    /*@Override
    public List<Bloc> getBlocByFoyer(Foyer id) {
        return blocRepository.getBlocByFoyer(id);
    }

    @Override
    public List<Bloc> get10(long id){
        return blocRepository.findByFoyerUniversiteIdUniversite(id);
    }*/
}
