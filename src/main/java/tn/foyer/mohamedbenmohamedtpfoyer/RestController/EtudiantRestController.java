package tn.foyer.mohamedbenmohamedtpfoyer.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IBlocService;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IEtudiantService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Etudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("EtudiantRestController")
public class EtudiantRestController {

    IEtudiantService etudiantService;

    @GetMapping("getAll")
    public List<Etudiant> getAll(){
        return etudiantService.selectAll();
    }

    @PostMapping("add")
    public Etudiant add (@RequestBody Etudiant etudiant){
        return etudiantService.add(etudiant);
    }

    @PostMapping("addAll")
    List<Etudiant> addAll(@RequestBody List<Etudiant> etudiants){
        return etudiantService.addAll(etudiants);
    }

    @GetMapping("findById")
    public Etudiant findById(@RequestParam int id_etudiant){
        return etudiantService.selectById(id_etudiant);
    }

    @PutMapping("Update")
    public Etudiant update(@RequestBody Etudiant etudiant){
        return etudiantService.update(etudiant);
    }

    @PutMapping("UpdateAll")
    List<Etudiant> updateAll(@RequestBody List<Etudiant> etudiants){
        return etudiantService.updateAll(etudiants);
    }

    @GetMapping("selectById")
    Etudiant selectById(@RequestParam int id_etudiant){
        return etudiantService.selectById(id_etudiant);
    }

    @GetMapping("selectAll")
    List<Etudiant> selectAll(){
        return etudiantService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam int id_etudiant){
        etudiantService.deleteById(id_etudiant);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Etudiant> etudiants){
        etudiantService.deleteAll(etudiants);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        etudiantService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return etudiantService.count();
    }
}
