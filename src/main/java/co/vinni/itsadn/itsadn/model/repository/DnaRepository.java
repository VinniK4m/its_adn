package co.vinni.itsadn.itsadn.model.repository;


import co.vinni.itsadn.itsadn.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Class to customize the special options to the database
 * @author Vinni - vinni_@yahoo.com
 */
public interface DnaRepository extends JpaRepository<Dna,Long> {
    List<Dna> findByType(String type);


}
