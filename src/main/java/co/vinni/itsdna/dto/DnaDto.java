package co.vinni.itsdna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DnaDto {
    private long id;

    private String arrayDna;
    private String type;
}
