package co.vinni.itsdna.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
@Setter
@Getter
@Entity
@Data
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statistics_seq")
    @SequenceGenerator(sequenceName = "sq_statistics", allocationSize = 1, name = "statistics_seq")
    private long id;

    private Integer countMutantDna;
    private Integer countHumanDna;
    private Double ratio;
    public Statistics(){
        countMutantDna = 0;
        countHumanDna = 0;
        ratio = 0.0;
    }
}
