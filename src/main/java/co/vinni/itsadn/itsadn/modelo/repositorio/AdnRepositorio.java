package co.vinni.itsadn.itsadn.modelo.repositorio;


import co.vinni.itsadn.itsadn.modelo.Adn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public interface AdnRepositorio extends JpaRepository<Adn,Long> {
    List<Adn> findByTipo(String tipo);


}