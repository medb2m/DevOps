package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.EtudiantRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Etudiant;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    // on creer une instance du repo
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> addAll(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        // si l'id n'existe pas ou null il ajoute un nouveau etudiant
        // si l'id existe il update
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> updateAll(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant selectById(long id) {
        //return etudiantRepository.findById(id).get(); // si il y a un etudiant retourne l'etudiant
        // sinon get() retourne empty new etudiant


        return etudiantRepository.findById(id).orElse(
                Etudiant.builder()
                .idEtudiant(0)
                .nomEt("test")
                .prenomEt("Test")
                .build());
        // si il y a un etudiant retourne l'etudiant
        // sinon retourne l'objet que je vais definir dans orElse()
    }

    @Override
    public List<Etudiant> selectAll() {
        return etudiantRepository.findAll();
    }



    @Override
    public void delete(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public void deleteById(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Etudiant> etudiants) {
        etudiantRepository.deleteAll(etudiants);
    }

    @Override
    public void deleteAll() {
        etudiantRepository.deleteAll();
    }

    @Override
    public long count() {
        return etudiantRepository.count();
    }
}
