package co.vinni.itsadn.itsadn.controller;


import co.vinni.itsadn.itsadn.model.Dna;
import co.vinni.itsadn.itsadn.model.Statistics;

import java.util.List;
/**
 * Operations for data base
 * @author Vinni - vinni_@yahoo.com
 */
public interface DnaControlerS {
    List<Dna> getAllDna();
    Dna saveDna(Dna dato);
    Statistics getStatistics();
}
