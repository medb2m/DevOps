package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import tn.foyer.mohamedbenmohamedtpfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant add(Etudiant etudiant);
    List<Etudiant> addAll(List<Etudiant> etudiants);
    Etudiant update(Etudiant etudiant);
    List<Etudiant> updateAll(List<Etudiant> etudiants);
    Etudiant selectById(long id);
    List<Etudiant> selectAll();
    void delete(Etudiant etudiant);
    void deleteById(long id);
    void deleteAll(List<Etudiant> etudiants);
    void deleteAll();
    long count();
}
