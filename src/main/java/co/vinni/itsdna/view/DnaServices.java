package co.vinni.itsdna.view;


import co.vinni.itsdna.controller.DnaControllerS;
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
public class DnaServices {

    @Autowired
    private DnaControllerS dnaController;

    @GetMapping("/")
    public List<Dna> initial(Model model){
        return dnaController.getAllDna();
    }
    @GetMapping("/stats")
    public ResponseEntity<Statistics> buildStats(Model model){
        Statistics stats =dnaController.getStatistics();

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
            dnaController.saveDna(dataDna);
            return ResponseEntity.ok().build();
        }
        else {
            dataDna.setType("HUMAN");
            dnaController.saveDna(dataDna);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("HUMAN");

        }

    }
}
