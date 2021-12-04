package co.vinni.itsadn.itsadn.controlador;

import co.vinni.itsadn.itsadn.modelo.Adn;
import co.vinni.itsadn.itsadn.modelo.Estadistica;

import java.util.List;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public interface AdnControlerS {
    List<Adn> getAllAdn();
    Adn guardaAdn(Adn dato);
    Estadistica getEstadisticas();
}