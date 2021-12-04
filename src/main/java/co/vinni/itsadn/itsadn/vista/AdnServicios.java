package co.vinni.itsadn.itsadn.vista;

import co.vinni.itsadn.itsadn.controlador.AdnControlerS;
import co.vinni.itsadn.itsadn.logica.VerificadorAdn;
import co.vinni.itsadn.itsadn.modelo.Adn;
import co.vinni.itsadn.itsadn.modelo.Estadistica;
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
@RequestMapping("/itsadn")
public class AdnServicios {

    @Autowired
    private AdnControlerS adnController;

    @GetMapping("/")
    public List<Adn> inicio(Model model){
        return adnController.getAllAdn();
    }
    @GetMapping("/stats")
    public ResponseEntity<Estadistica> generaEstadistica(Model model){
        Estadistica estadistica =adnController.getEstadisticas();

        return ResponseEntity.ok(estadistica);
    }
    @PostMapping("/mutant")
    public ResponseEntity esMutante(@RequestBody Adn datoAdn){
        //System.out.println(datoAdn);
        VerificadorAdn verif = new VerificadorAdn();
        Boolean rta = verif.isMutant(datoAdn.getDna());
        if (rta == null) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ERROR STRUCTURE");
        }

        if(rta) {
            datoAdn.setTipo("MUTANT");
            adnController.guardaAdn(datoAdn);
            return ResponseEntity.ok().build();
        }
        else {
            datoAdn.setTipo("HUMAN");
            adnController.guardaAdn(datoAdn);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("HUMAN");

        }

    }
}
