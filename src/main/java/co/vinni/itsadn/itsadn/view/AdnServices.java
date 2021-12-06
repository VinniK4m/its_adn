package co.vinni.itsadn.itsadn.view;


import co.vinni.itsadn.itsadn.controller.DnaControlerS;
import co.vinni.itsadn.itsadn.logic.ChequedDna;
import co.vinni.itsadn.itsadn.model.Dna;
import co.vinni.itsadn.itsadn.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Class that provides the API operations
 * @author Vinni - vinni_@yahoo.com
 */
@RestController
@RequestMapping("/itsdna")
public class AdnServices {

    @Autowired
    private DnaControlerS dnaController;

    @GetMapping("/")
    public List<Dna> inicio(Model model){
        return dnaController.getAllDna();
    }
    @GetMapping("/stats")
    public ResponseEntity<Statistics> generaEstadistica(Model model){
        Statistics estadistica =dnaController.getStatistics();

        return ResponseEntity.ok(estadistica);
    }
    @PostMapping("/mutant")
    public ResponseEntity esMutante(@RequestBody Dna dataAdn){
        ChequedDna verif = new ChequedDna();
        Boolean rta = verif.isMutant(dataAdn.getDna());
        if (rta == null) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ERROR STRUCTURE");
        }

        if(rta) {
            dataAdn.setType("MUTANT");
            dnaController.saveDna(dataAdn);
            return ResponseEntity.ok().build();
        }
        else {
            dataAdn.setType("HUMAN");
            dnaController.saveDna(dataAdn);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("HUMAN");

        }

    }
}
