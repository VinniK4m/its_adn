package co.vinni.itsadn.itsadn.controlador;

import co.vinni.itsadn.itsadn.modelo.Adn;
import co.vinni.itsadn.itsadn.modelo.repositorio.AdnRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
