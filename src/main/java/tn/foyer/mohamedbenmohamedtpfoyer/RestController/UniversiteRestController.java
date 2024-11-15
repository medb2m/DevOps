package tn.foyer.mohamedbenmohamedtpfoyer.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IUniversiteService;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.UniversiteService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Universite;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("UniversiteRestController")
public class UniversiteRestController {

    IUniversiteService universiteService;

    @GetMapping("getAll")
    public List<Universite> getAll(){
        return universiteService.selectAll();
    }

    @PostMapping("add")
    public Universite add (@RequestBody Universite universite){
        return universiteService.add(universite);
    }

    @PostMapping("addAll")
    List<Universite> addAll(@RequestBody List<Universite> universites){
        return universiteService.addAll(universites);
    }

    @GetMapping("findById")
    public Universite findById(@RequestParam int id_universite){
        return universiteService.selectById(id_universite);
    }

    @PutMapping("Update")
    public Universite update(@RequestBody Universite universite){
        return universiteService.update(universite);
    }

    @PutMapping("UpdateAll")
    List<Universite> updateAll(@RequestBody List<Universite> universites){
        return universiteService.updateAll(universites);
    }

    @GetMapping("selectById")
    Universite selectById(@RequestParam int id_universite){
        return universiteService.selectById(id_universite);
    }

    @GetMapping("selectAll")
    List<Universite> selectAll(){
        return universiteService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam int id_universite){
        universiteService.deleteById(id_universite);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Universite> universites){
        universiteService.deleteAll(universites);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        universiteService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return universiteService.count();
    }

    @PutMapping("affecterFoyerAUniversite/{idF}/{idU}")
    public void affecterFoyerAUniversite(@PathVariable long idF, @PathVariable long idU){
        universiteService.affecterFoyerAUniversite(idF,idU);
    }

    @PostMapping("ajouterUniversiteETSonFoyer")
            public void ajouterUniversiteETSonFoyer(@RequestBody Universite u){
        universiteService.ajouterUniversiteETSonFoyer(u);
    };

}
