package co.vinni.itsdna;

import co.vinni.itsdna.dto.DnaDto;
import co.vinni.itsdna.view.DnaImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DnaImplementationTest {
    @Autowired
    DnaImplementation dnaImplementation;

    @Test
    void getAllok() {

        assertNotNull(dnaImplementation.getAllDna());
    }
    @Test
    void getStatistics() {

        assertNotNull(dnaImplementation.getStatistics());
    }
    @Test
    void saveDnaOK() {
        DnaDto dnaDto = new DnaDto();
        dnaDto.setArrayDna("ATGCGA;CTGTAC;TTATGT;AGAAGG;CCGCTA;TCACTG");
        dnaDto.setType("HUMAN");
        assertNotNull(dnaImplementation.saveDna(dnaDto));
    }
    @Test
    void saveDnaEmpty() {
        DnaDto dnaDto = new DnaDto(1, "", "");
        assertNull(dnaImplementation.saveDna(dnaDto));
    }
    @Test
    void saveDnaNull() {

        assertNull(dnaImplementation.saveDna(null));
    }
    @Test
    void getVersion() {

        assertNotNull(dnaImplementation.getVersion());
    }


}
