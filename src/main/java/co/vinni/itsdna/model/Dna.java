package co.vinni.itsdna.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Vinni - vinni_@yahoo.com
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dna implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_appadn", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;

    private String arrayDna;
    private String type;


}
