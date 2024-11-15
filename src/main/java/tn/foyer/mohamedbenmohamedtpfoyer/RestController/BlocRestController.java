package tn.foyer.mohamedbenmohamedtpfoyer.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.foyer.mohamedbenmohamedtpfoyer.Services.IBlocService;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Bloc;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("BlocRestController")
@Tag(name = "Bloc API", description = "Manage Bloc operations like CRUD")
public class BlocRestController {

    IBlocService blocService;
    @Operation(summary = "Get all blocs", description = "Retrieve all blocs from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "Blocs not found")
    })
    @GetMapping("getAll")
    public List<Bloc> getAll(){
        return blocService.selectAll();
    }

    @Operation(summary = "Add a new bloc", description = "Create a new bloc")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bloc successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("add")
    public Bloc add (@RequestBody Bloc bloc){
        return blocService.add(bloc);
    }

    @PostMapping("addAll")
    List<Bloc> addAll(@RequestBody List<Bloc> blocs){
        return blocService.addAll(blocs);
    }

    @Operation(summary = "Find bloc by ID", description = "Get a specific bloc by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bloc found"),
            @ApiResponse(responseCode = "404", description = "Bloc not found")
    })
    @GetMapping("findById")
    public Bloc findById(@RequestParam int id_bloc){
        return blocService.selectById(id_bloc);
    }

    @PutMapping("Update")
    public Bloc update(@RequestBody Bloc bloc){
        return blocService.update(bloc);
    }

    @PutMapping("UpdateAll")
    List<Bloc> updateAll(@RequestBody List<Bloc> blocs){
        return blocService.updateAll(blocs);
    }

    @GetMapping("selectById")
    Bloc selectById(@RequestParam int id_bloc){
        return blocService.selectById(id_bloc);
    }

    @GetMapping("selectAll")
    List<Bloc> selectAll(){
        return blocService.selectAll();
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam int id_bloc){
        blocService.deleteById(id_bloc);
    }

    @DeleteMapping("deleteAll1")
    void deleteAll(@RequestBody List<Bloc> blocs){
        blocService.deleteAll(blocs);
    }

    @DeleteMapping("deleteAll2")
    void deleteAll2(){
        blocService.deleteAll();
    }

    @GetMapping("count")
    long count(){
        return blocService.count();
    }


    @GetMapping("findBlocsByFoyerId")
    List<Bloc> findBlocsByFoyerId(long idFoyer){
        return blocService.findBlocsByFoyerId(idFoyer);
    }

    @PostMapping("ajouterBlocETSesChambres")
    Bloc ajouterBlocETSesChambres(@RequestBody Bloc b){
        return blocService.ajouterBlocETSesChambres(b);
    }

    @PostMapping("ajouterBlocETAffecterAfoyer")
    Bloc ajouterBlocETAffecterAfoyer(@RequestBody Bloc b, @RequestParam String nomFoyer){
        return blocService.ajouterBlocETAffecterAfoyer(b,nomFoyer);
    }

    @DeleteMapping("deleteBloc")
    void deleteBloc(@RequestParam long idBloc){
        blocService.deleteBloc(idBloc);
    }

    @GetMapping("jib")
    public List<Bloc> jibBloc(@RequestParam String nomB){ return blocService.jibByNomm(nomB);}

    /*@GetMapping("blocF")
    List<Bloc> getBlocByFoyer(Foyer id){
        return blocService.getBlocByFoyer(id);
    }

    @GetMapping("getBlocByFoyerByUniversity")
    List<Bloc> num10(long id){
        return blocService.get10(id);
    }*/
}
