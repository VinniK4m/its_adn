package co.vinni.itsadn.itsadn.controlador;

import co.vinni.itsadn.itsadn.modelo.Adn;
import co.vinni.itsadn.itsadn.modelo.Estadistica;
import co.vinni.itsadn.itsadn.modelo.repositorio.AdnRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
@Log4j2
@Service
public class AdnImplemetacion implements AdnControlerS
{
    @Autowired
    private AdnRepositorio adnRepositorio;
    @Override
    public List<Adn> getAllAdn() {
        return  adnRepositorio.findAll();
    }

    @Override
    public Adn guardaAdn(Adn dato) {
        return adnRepositorio.save(dato);
    }

    @Override
    public Adn editarAdn(Adn dato) {
        return adnRepositorio.save(dato);
    }

    @Override
    public Adn getAdnbyID(long id) {
        Optional<Adn> optional= Optional.ofNullable(this.getAdnbyID(id));
        Adn adn = null;
        if (optional.isPresent()){
            adn = optional.get();
        }else{
            log.error("No se encuentra un Adn por el Id recibido ");
        }
        return adn;
    }

    @Override
    public void borrarAdnbyId(long id) {
        adnRepositorio.deleteById(id);
    }


    public Estadistica getEstadisticas() {
        Estadistica estadistica = new Estadistica();
        List<Adn> adnMutant =  this.adnRepositorio.findByTipo("MUTANT");
        List<Adn> adnHuman =  this.adnRepositorio.findByTipo("HUMAN");
        estadistica.setCountMutantDna(adnMutant.size());
        estadistica.setCountHumanDna(adnHuman.size());
        Double mut = Double.parseDouble(""+adnMutant.size());
        Double hum = Double.parseDouble(""+adnHuman.size());
        if (hum > 0) {
            estadistica.setRatio(mut / hum);
        }
        return estadistica;
    }
}
