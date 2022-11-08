package co.vinni.itsdna.view;


import co.vinni.itsdna.dto.DnaDto;
import co.vinni.itsdna.model.Dna;
import co.vinni.itsdna.model.Statistics;

import java.util.List;
/**
 * Operations for data base
 * @author Vinni - vinni_@yahoo.com
 */
public interface DnaService {
    List<Dna> getAllDna();
    void saveDna(DnaDto data);
    Statistics getStatistics();

    String getVersion();
}
