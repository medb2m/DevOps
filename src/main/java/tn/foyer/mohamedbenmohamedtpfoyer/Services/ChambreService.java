package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.ChambreRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.ReservationRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Reservation;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.TypeChambre;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
    @Override
    public Chambre add(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> addAll(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> updateAll(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre selectById(long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public List<Chambre> selectAll() {
        return chambreRepository.findAll();
    }

    @Override
    public void delete(Chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public void deleteById(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Chambre> chambres) {
        chambreRepository.deleteAll(chambres);
    }

    @Override
    public void deleteAll() {
        chambreRepository.deleteAll();
    }

    @Override
    public long count() {
        return chambreRepository.count();
    }

    @Override
    public List<Chambre> getChambresParNomBlocKeyW(String nombloc) {

        return chambreRepository.findByBlocNomBlocContaining(nombloc);
    }
    @Override
    public List<Chambre> getChambresParNomBlocJPQL(String nombloc) {

        return chambreRepository.findChambresByNomBlocJPQL(nombloc);
    }
    @Override
    public List<Chambre> getChambresParNomBlocSQL(String nombloc) {

        return chambreRepository.findChambresByNomBlocSQL(nombloc);
    }


    @Scheduled(fixedRate = 300000)
    public void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres = chambreRepository.findAll();
        long totalChambres = chambres.size();
        //long totalChambres = count();
        log.info("Nombre totale des chambres " + totalChambres);

        int nbSimple = 0;
        int nbDouble = 0;
        int nbTriple = 0;

        for (Chambre ch : chambres) {
            if (ch.getTypeC() == TypeChambre.SIMPLE) {
                nbSimple++;
            } else if (ch.getTypeC() == TypeChambre.DOUBLE) {
                nbDouble++;
            } else if (ch.getTypeC() == TypeChambre.TRIPLE) {
                nbTriple++;
            }
        }

        // Calculate percentages, ensuring no division by zero
        double pctSimple = (totalChambres > 0) ? (nbSimple * 100.0 / totalChambres) : 0;
        double pctDouble = (totalChambres > 0) ? (nbDouble * 100.0 / totalChambres) : 0;
        double pctTriple = (totalChambres > 0) ? (nbTriple * 100.0 / totalChambres) : 0;

        // Log the calculated percentages
        log.info("Pourcentage de chambres de type SIMPLE: " + pctSimple + "%");
        log.info("Pourcentage de chambres de type DOUBLE: " + pctDouble + "%");
        log.info("Pourcentage de chambres de type TRIPLE: " + pctTriple + "%");
    }

    ReservationRepository reservationRepository;

    @Scheduled(fixedRate = 300000)
    void nbPlacesDisponibleParChambreAnneeEnCours(){
        LocalDate currentYear = LocalDate.now();
        List<Reservation> reservationsForCurrentYear = reservationRepository.findReservationsForCurrentYear(currentYear);

        
    }




}
