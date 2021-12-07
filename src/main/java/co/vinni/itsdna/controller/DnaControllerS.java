package co.vinni.itsdna.controller;


import co.vinni.itsdna.model.Dna;
import co.vinni.itsdna.model.Statistics;

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
