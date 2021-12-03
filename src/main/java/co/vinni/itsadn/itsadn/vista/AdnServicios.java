package co.vinni.itsadn.itsadn.vista;

import co.vinni.itsadn.itsadn.controlador.AdnControlerS;
import co.vinni.itsadn.itsadn.modelo.Adn;
import co.vinni.itsadn.itsadn.modelo.Estadistica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Estadistica generaEstadistica(Model model){
        return null;
    }
    @PostMapping("/mutant")
    public String esMutante(@RequestBody Adn datoAdn){


        return "";//this.adnController.guardaActo(datoAdn);

    }
}
