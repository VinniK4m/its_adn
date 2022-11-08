package co.vinni.itsdna.view;

import co.vinni.itsdna.DnaDto;
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
public class DnaImplementation implements DnaService
{
    @Autowired
    private DnaRepository dnaRepository;
    @Override
    public List<Dna> getAllDna() {
        return  dnaRepository.findAll();
    }

    @Override
    public void saveDna(DnaDto data) {
        Dna entity = this.convertToEntity(data);
        dnaRepository.save(entity);
    }

    /**
     * Method for change dto to entity
     * @param data
     * @return
     */
    private Dna convertToEntity(DnaDto data) {
        return new Dna(data.getId(), data.getDna(), data.getType());
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


    /**
     * Method for version
     * @return
     */
    public String getVersion() {
        String version = "";
        List<Dna> adnMutant =  this.dnaRepository.findByType("MUTANT");
        if (!adnMutant.isEmpty()){
            version = "version "+adnMutant.size();
        }
        return version;

    }
}
