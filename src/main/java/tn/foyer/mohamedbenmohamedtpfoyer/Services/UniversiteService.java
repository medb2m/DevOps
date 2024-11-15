package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.FoyerRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.UniversiteRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Universite;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite add(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> addAll(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> updateAll(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public Universite selectById(long id) {
        return null;
    }

    @Override
    public List<Universite> selectAll() {
        return null;
    }

    @Override
    public void delete(Universite universite) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll(List<Universite> universites) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void affecterFoyerAUniversite(long id_foyer, long id_universite) {
        Universite universite = universiteRepository.findById(id_universite).get();
        Foyer foyer = foyerRepository.findById(id_foyer).get();
        // on affecte le child au parent
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
    }

    @Override
    public void ajouterUniversiteETSonFoyer(Universite u) {
        universiteRepository.save(u);
    }
}
