package tn.foyer.mohamedbenmohamedtpfoyer.RestController;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IChambreService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Chambre;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("ChambreRestController")
public class ChambreRestController {

    IChambreService chambreService;

    @GetMapping("getAll")
    public List<Chambre> getAll(){
        return chambreService.selectAll();
    }

    @PostMapping("add")
    public Chambre add (@RequestBody Chambre chambre){
        return chambreService.add(chambre);
    }

    @PostMapping("addAll")
    List<Chambre> addAll(@RequestBody List<Chambre> chambres){
        return chambreService.addAll(chambres);
    }

    @GetMapping("findById")
    public Chambre findById(@RequestParam int id_chambre){
        return chambreService.selectById(id_chambre);
    }

    @PutMapping("Update")
    public Chambre update(@RequestBody Chambre chambre){
        return chambreService.update(chambre);
    }

    @PutMapping("UpdateAll")
    List<Chambre> updateAll(@RequestBody List<Chambre> chambres){
        return chambreService.updateAll(chambres);
    }

    @GetMapping("selectById")
    Chambre selectById(@RequestParam int id_chambre){
        return chambreService.selectById(id_chambre);
    }

    @GetMapping("selectAll")
    List<Chambre> selectAll(){
        return chambreService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam int id_chambre){
        chambreService.deleteById(id_chambre);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Chambre> blocs){
        chambreService.deleteAll(blocs);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        chambreService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return chambreService.count();
    }

    @GetMapping("getChambresParNomBlocKeyW")
    List<Chambre> getChambresParNomBlocKeyW(@RequestParam String nombloc){
        return chambreService.getChambresParNomBlocKeyW(nombloc);
    }
    @GetMapping("getChambresParNomBlocJPQL")
    List<Chambre> getChambresParNomBlocJPQL(@RequestParam String nombloc){
        return chambreService.getChambresParNomBlocJPQL(nombloc);
    }
    @GetMapping("getChambresParNomBlocSQL")
    List<Chambre> getChambresParNomBlocSQL(@RequestParam String nombloc){
        return chambreService.getChambresParNomBlocSQL(nombloc);
    }
}
