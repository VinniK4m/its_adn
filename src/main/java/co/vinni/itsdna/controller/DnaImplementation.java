package co.vinni.itsdna.controller;

import co.vinni.itsdna.model.Dna;
import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.model.repository.DnaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Class implements operations data base
 * @author Vinni - vinni_@yahoo.com
 */
@Log4j2
@Service
public class DnaImplementation implements DnaControllerS
{
    @Autowired
    private DnaRepository dnaRepository;
    @Override
    public List<Dna> getAllDna() {
        return  dnaRepository.findAll();
    }

    @Override
    public void saveDna(Dna data) {
        dnaRepository.save(data);
    }

    public Statistics getStatistics() {
        Statistics stats = new Statistics();
        List<Dna> adnMutant =  this.dnaRepository.findByType("MUTANT");
        List<Dna> adnHuman =  this.dnaRepository.findByType("HUMAN");
        stats.setCountMutantDna(adnMutant.size());
        stats.setCountHumanDna(adnHuman.size());
        double  mut = Double.parseDouble(""+adnMutant.size());
        double hum = Double.parseDouble(""+adnHuman.size());
        if (hum > 0) {
            stats.setRatio(mut / hum);
        }
        return stats;
    }
}
