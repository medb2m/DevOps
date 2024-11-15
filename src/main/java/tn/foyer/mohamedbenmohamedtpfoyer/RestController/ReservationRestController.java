package tn.foyer.mohamedbenmohamedtpfoyer.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IReservationService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Reservation;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("ReservationRestController")
public class ReservationRestController {

    IReservationService reservationService;

    @GetMapping("getAll")
    public List<Reservation> getAll(){
        return reservationService.selectAll();
    }

    @PostMapping("add")
    public Reservation add (@RequestBody Reservation reservation){
        return reservationService.add(reservation);
    }

    @PostMapping("addAll")
    List<Reservation> addAll(@RequestBody List<Reservation> reservations){
        return reservationService.addAll(reservations);
    }

    @GetMapping("findById")
    public Reservation findById(@RequestParam String id_reservation){
        return reservationService.selectById(id_reservation);
    }

    @PutMapping("Update")
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @PutMapping("UpdateAll")
    List<Reservation> updateAll(@RequestBody List<Reservation> reservations){
        return reservationService.updateAll(reservations);
    }

    @GetMapping("selectById")
    Reservation selectById(@RequestParam String id_reservation){
        return reservationService.selectById(id_reservation);
    }

    @GetMapping("selectAll")
    List<Reservation> selectAll(){
        return reservationService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam String id_reservation){
        reservationService.deleteById(id_reservation);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Reservation> reservations){
        reservationService.deleteAll(reservations);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        reservationService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return reservationService.count();
    }

    @GetMapping("ajouterReservationEtAssingnerAChambreEtAEtudiant")
    Reservation ajouterReservationEtAssingnerAChambreEtAEtudiant(@RequestParam long numChambre,@RequestParam int cin){
        return reservationService.ajouterReservationEtAssingnerAChambreEtAEtudiant(numChambre,cin);
    }
}
