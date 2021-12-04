package co.vinni.itsadn.itsadn;

import co.vinni.itsadn.itsadn.logica.VerificadorAdn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VerificadorAdnTest {
    private final VerificadorAdn verificador;
    public VerificadorAdnTest(){
        verificador = new VerificadorAdn();
    }

    /**
     * Verifica que sea null
     */
    @Test
    void verificarNull() {
        boolean rta = verificador.isMutant(null);
        assertFalse(rta);
    }
    /**
     * Verifica que todos las cadenas tengan la longitud completa
     */
    @Test
    void verificarLongitudDif() {
        String[] dna = {"ATGCA","CATGC","GT","","CCCCTA","TCTG", "TCACTG"};
        boolean rta = verificador.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Verifica que tenga el numero nxn de filas y datos
     */
    @Test
    void verificarTamano() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
        boolean rta = verificador.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Verifica que no tenga caracteres diferentes a ATGC
     */
    @Test
    void verificarCaracteres() {
        String[] dna = {"ATGNGA","CAGTWC","TEATGT","AGUAGG","CCCCTA", "CCMCTA"};
        boolean rta = verificador.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Verifica si es mutante
     */
    @Test
    void verificarEsMutante() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean rta = verificador.isMutant(dna);
        System.out.println(rta);
        assertTrue(rta);
    }
    /**
     * Verifica que no sea mutante
     */
    @Test
    void verificarNoEsMutante() {
        String[] dna =  {"ATGCGA","CTGTAC","TTATGT","AGAAGG","CCGCTA","TCACTG"};
        boolean rta = verificador.isMutant(dna);
        assertFalse(rta);
    }
}
