package co.vinni.itsadn.itsadn.controller;


import co.vinni.itsadn.itsadn.model.Dna;
import co.vinni.itsadn.itsadn.model.Statistics;

import java.util.List;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public interface DnaControllerS {
    List<Dna> getAllDna();
    void saveDna(Dna data);
    Statistics getStatistics();
}
