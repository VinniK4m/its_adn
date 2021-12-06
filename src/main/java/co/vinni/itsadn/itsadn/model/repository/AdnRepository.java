package co.vinni.itsadn.itsadn.model.repository;


import co.vinni.itsadn.itsadn.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public interface AdnRepository extends JpaRepository<Dna,Long> {
    List<Dna> findByType(String tipo);


}