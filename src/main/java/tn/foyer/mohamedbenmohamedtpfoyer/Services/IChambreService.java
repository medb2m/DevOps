package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre add(Chambre chambre);
    List<Chambre> addAll(List<Chambre> chambres);
    Chambre update(Chambre chambre);
    List<Chambre> updateAll(List<Chambre> chambres);
    Chambre selectById(long id);
    List<Chambre> selectAll();
    void delete(Chambre chambre);
    void deleteById(long id);
    void deleteAll(List<Chambre> chambres);
    void deleteAll();
    long count();

    List<Chambre> getChambresParNomBlocKeyW(String nombloc);
    List<Chambre> getChambresParNomBlocJPQL(String nombloc);
    List<Chambre> getChambresParNomBlocSQL(String nombloc);
}
