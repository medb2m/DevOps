package tn.foyer.mohamedbenmohamedtpfoyer.RestController;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IFoyerService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("FoyerRestController")
public class FoyerRestController {
    IFoyerService foyerService;

    @GetMapping("getAll")
    public List<Foyer> getAll(){
        return foyerService.selectAll();
    }

    @PostMapping("add")
    public Foyer add (@RequestBody Foyer foyer){
        return foyerService.add(foyer);
    }

    @PostMapping("addAll")
    List<Foyer> addAll(@RequestBody List<Foyer> foyers){
        return foyerService.addAll(foyers);
    }

    @GetMapping("findById")
    public Foyer findById(@RequestParam int id_foyer){
        return foyerService.selectById(id_foyer);
    }

    @PutMapping("Update")
    public Foyer update(@RequestBody Foyer foyer){
        return foyerService.update(foyer);
    }

    @PutMapping("UpdateAll")
    List<Foyer> updateAll(@RequestBody List<Foyer> foyers){
        return foyerService.updateAll(foyers);
    }

    @GetMapping("selectById")
    Foyer selectById(@RequestParam int id_foyer){
        return foyerService.selectById(id_foyer);
    }

    @GetMapping("selectAll")
    List<Foyer> selectAll(){
        return foyerService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam int id_foyer){
        foyerService.deleteById(id_foyer);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Foyer> foyers){
        foyerService.deleteAll(foyers);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        foyerService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return foyerService.count();
    }
}
