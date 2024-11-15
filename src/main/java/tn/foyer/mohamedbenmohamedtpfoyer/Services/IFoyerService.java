package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer add(Foyer foyer);
    List<Foyer> addAll(List<Foyer> foyers);
    Foyer update(Foyer foyer);
    List<Foyer> updateAll(List<Foyer> foyers);
    Foyer selectById(long id);
    List<Foyer> selectAll();
    void delete(Foyer foyer);
    void deleteById(long id);
    void deleteAll(List<Foyer> foyers);
    void deleteAll();
    long count();
}
