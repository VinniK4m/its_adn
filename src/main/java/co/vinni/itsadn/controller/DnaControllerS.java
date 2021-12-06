package co.vinni.itsadn.controller;


import co.vinni.itsadn.model.Dna;
import co.vinni.itsadn.model.Statistics;

import java.util.List;
/**
 * Operations for data base
 * @author Vinni - vinni_@yahoo.com
 */
public interface DnaControllerS {
    List<Dna> getAllDna();
    void saveDna(Dna data);
    Statistics getStatistics();
}
