package co.vinni.itsdna.controller;


import co.vinni.itsdna.view.DnaService;
import co.vinni.itsdna.logic.CheckedDna;
import co.vinni.itsdna.model.Dna;
import co.vinni.itsdna.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
@RestController
@RequestMapping("/itsdna")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @GetMapping("/")
    public List<Dna> initial(Model model){
        return dnaService.getAllDna();
    }

    @GetMapping("/abc/")
    public List<Dna> initialAbc(Model model){
        return dnaService.getAllDna();
    }

    @GetMapping("/version")
    public ResponseEntity version(){
        String version = dnaService.getVersion();
        return ResponseEntity.status(HttpStatus.OK).body(version);
    }

    @GetMapping("/stats")
    public ResponseEntity<Statistics> buildStats(Model model){
        Statistics stats =dnaService.getStatistics();

        return ResponseEntity.ok(stats);
    }
    @PostMapping("/mutant")
    public ResponseEntity isMutant(@RequestBody Dna dataDna){
        CheckedDna verify = new CheckedDna();
        Boolean rta = verify.isMutant(dataDna.getDna());
        if (rta == null) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ERROR STRUCTURE");
        }

        if(rta) {
            dataDna.setType("MUTANT");
            dnaService.saveDna(dataDna);
            return ResponseEntity.ok().build();
        }
        else {
            dataDna.setType("HUMAN");
            dnaService.saveDna(dataDna);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("HUMAN");

        }

    }
}
