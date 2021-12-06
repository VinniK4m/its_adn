package co.vinni.itsadn.itsadn.model;

import lombok.*;

import javax.persistence.*;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dna {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_appadn", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;

    private String[] dna;
    private String type;


}
