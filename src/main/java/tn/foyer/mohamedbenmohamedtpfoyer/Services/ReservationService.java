package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.ChambreRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.EtudiantRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.ReservationRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Etudiant;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{

    ReservationRepository reservationRepository;

    ChambreRepository chambreRepository;

    EtudiantRepository etudiantRepository;
    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> addAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> updateAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation selectById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> selectAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Reservation> reservations) {
        reservationRepository.deleteAll(reservations);
    }

    @Override
    public void deleteAll() {
        reservationRepository.deleteAll();
    }

    @Override
    public long count() {
        return reservationRepository.count();
    }

    @Override
    public void affecterReservationAChambre(String idRes, long idChambre) {
        // Step 1: Fetch the reservation by its ID
        Reservation reservation = reservationRepository.findById(idRes)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        // Step 2: Fetch the chambre by its ID
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));

        // Step 3: Associate the reservation with the chambre
        chambre.getReservations().add(reservation);

        // Step 4: Save the updated chambre
        chambreRepository.save(chambre);
    }

    @Override
    public Reservation ajouterReservationEtAssingnerAChambreEtAEtudiant(long numChambre, int cin) {
        // creation de l'id depuis annee-universitaire - NomBloc - NumChambre - Cin

        // test si la capacité maximale de la chambre n'est pas depassé
        // La date La date de réservation est egale à la date du systeme et estValide par defaut true

        // Fetch the Chambre by numChambre
        Chambre chambre = chambreRepository.findByNumeroChambre(numChambre);
        if (chambre == null) {
            throw new IllegalArgumentException("Chambre not found");
        }

        // Fetch the Etudiant by cin
        Etudiant etudiant =  etudiantRepository.findByCin(cin);
        if (etudiant == null) {
            throw new IllegalArgumentException("Etudiant not found");
        }
        // Check if the room capacity is exceeded based on typeC
        int maxCapacity;
        switch (chambre.getTypeC()) {
            case SIMPLE:
                maxCapacity = 1;
                break;
            case DOUBLE:
                maxCapacity = 2;
                break;
            case TRIPLE:
                maxCapacity = 3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chambre.getTypeC());
        }

        // Check if the current number of reservations meets or exceeds the maximum capacity
        if (chambre.getReservations().size() >= maxCapacity) {
            throw new IllegalStateException("Room capacity exceeded for type " + chambre.getTypeC());
        }

        // Check if a reservation for the student already exists in the chambre
        boolean reservationExists = chambre.getReservations().stream()
                .anyMatch(reservation -> reservation.getEtudiants().contains(etudiant));

        if (reservationExists) {
            throw new IllegalStateException("Reservation for this student already exists in the room");
        }

        // Generate the reservation ID based on the academic year and identifiers
        int year = LocalDate.now().getYear() % 100;
        LocalDate dateDebutAU, dateFinAU;
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }

        String idReservation = String.format("%d-%s-%d-%d", year, chambre.getBloc().getNomBloc(), numChambre, cin);

        // Create the Reservation
        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(dateDebutAU);
        reservation.setEstValide(true);

        // Add the student to the reservation
        reservation.setEtudiants(Collections.singletonList(etudiant));

        // Persist the reservation
        Reservation savedReservation = reservationRepository.save(reservation);

        // Associate reservation with the chambre
        chambre.getReservations().add(savedReservation);
        chambreRepository.save(chambre);

        // Associate reservation with the student
        etudiant.getReservations().add(savedReservation);
        etudiantRepository.save(etudiant);

        return savedReservation;
    }



}
