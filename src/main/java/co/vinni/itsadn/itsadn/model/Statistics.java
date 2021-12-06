package co.vinni.itsadn.itsadn.model;

import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
@Setter
@Getter
public class Statistics {
    private Integer countMutantDna;
    private Integer countHumanDna;
    private Double ratio;
    public Statistics(){
        countMutantDna = 0;
        countHumanDna = 0;
        ratio = 0.0;
    }
}
