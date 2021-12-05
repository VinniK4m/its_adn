package co.vinni.itsadn.itsadn;

import co.vinni.itsadn.itsadn.logic.ChequedDna;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ChequedDnaTest {
    private final ChequedDna chequed;
    public ChequedDnaTest(){
        chequed = new ChequedDna();
    }

    /**
     * Test check dna is null
     */
    @Test
    void verifyNull() {
        boolean rta = chequed.isMutant(null);
        assertFalse(rta);
    }
    /**
     * Test check length of dna is complete
     */
    @Test
    void verifyLengthDif() {
        String[] dna = {"ATGCA","CATGC","GT","","CCCCTA","TCTG", "TCACTG"};
        boolean rta = chequed.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Test check size structure dna is nxn in row and data
     */
    @Test
    void verifySize() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
        boolean rta = chequed.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Test Check that it only containts the charactes "ACGT"
     */
    @Test
    void verifyCharacters() {
        String[] dna = {"ATGNGA","CAGTWC","TEATGT","AGUAGG","CCCCTA", "CCMCTA"};
        boolean rta = chequed.isMutant(dna);
        assertFalse(rta);
    }
    /**
     * Test check string dna result Mutant
     */
    @Test
    void verifyIsMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean rta = chequed.isMutant(dna);
        System.out.println(rta);
        assertTrue(rta);
    }
    /**
     * Test check string dna result Human
     */
    @Test
    void verifyIsHuman() {
        String[] dna =  {"ATGCGA","CTGTAC","TTATGT","AGAAGG","CCGCTA","TCACTG"};
        boolean rta = chequed.isMutant(dna);
        assertFalse(rta);
    }
}
