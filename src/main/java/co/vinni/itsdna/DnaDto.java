package co.vinni.itsdna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DnaDto {
    private long id;

    private String[] dna;
    private String type;
}
