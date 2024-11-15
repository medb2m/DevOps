package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import tn.foyer.mohamedbenmohamedtpfoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation add(Reservation reservation);
    List<Reservation> addAll(List<Reservation> reservations);

    Reservation update(Reservation reservation);
    List<Reservation> updateAll(List<Reservation> reservations);
    Reservation selectById(String id);
    List<Reservation> selectAll();
    void delete(Reservation reservation);
    void deleteById(String id);
    void deleteAll(List<Reservation> reservations);
    void deleteAll();
    long count();

    void affecterReservationAChambre(String idRes, long idChambre);

    Reservation ajouterReservationEtAssingnerAChambreEtAEtudiant(long numChambre, int cin);
}
