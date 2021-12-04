package co.vinni.itsadn.itsadn.modelo;

import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
@Setter
@Getter
public class Estadistica {
    private Integer countMutantDna;
    private Integer countHumanDna;
    private Double ratio;
    public Estadistica(){
        countMutantDna = 0;
        countHumanDna = 0;
        ratio = 0.0;
    }
}
