package co.vinni.itsdna;

import co.vinni.itsdna.logic.CheckedDna;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckedDnaTest {
    private final CheckedDna checked;
    CheckedDnaTest(){
        checked = new CheckedDna();
    }

    /**
     * Test check dna is null
     */
    @Test
    void verifyNull() {
        String [][] matrix = checked.buildMatrix(null);
        assertEquals(0, matrix.length);
    }
    /**
     * Test check length of dna is complete
     */
    @Test
    void verifyLengthDif() {
        String[] dna = {"ATGCA","CATGC","GT","","CCCCTA","TCTG", "TCACTG"};
        String [][] matrix = checked.buildMatrix(dna);
        assertEquals(0, matrix.length);
    }
    /**
     * Test check size structure dna is nxn in row and data
     */
    @Test
    void verifySize() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
        String [][] matrix = checked.buildMatrix(dna);
        assertEquals(0, matrix.length);
    }
    /**
     * Test Check that it only containts the charactes "ACGT"
     */
    @Test
    void verifyCharacters() {
        String[] dna = {"ATGNGA","CAGTWC","TEATGT","AGUAGG","CCCCTA", "CCMCTA"};
        String [][] matrix = checked.buildMatrix(dna);
        boolean rta = checked.verifyContent(matrix);
        assertFalse(rta);
    }

    /**
     * test checked DNA don't empty
     */
    @Test
    void verifyEmpty() {
        String[] dna = {};
        String [][] matrix = checked.buildMatrix(dna);
        assertEquals(0, matrix.length);
    }
    /**
     * Test check string dna result Mutant
     */
    @Test
    void verifyHorizontalOK() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String [][] matrix = checked.buildMatrix(dna);
        boolean rta = checked.validateHorizontal(matrix);
        assertTrue(rta);
    }
    /**
     * Test check string dna result Mutant
     */
    @Test
    void verifyVerticalOK() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String [][] matrix = checked.buildMatrix(dna);
        boolean rta = checked.validateVertical(matrix);
        assertTrue(rta);
    }
    /**
     * Test check string dna result Mutant
     */
    @Test
    void verifyDiagonalOK() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String [][] matrix = checked.buildMatrix(dna);
        boolean rta = checked.validateDiagonal(matrix);
        assertTrue(rta);
    }
    /**
     * Test check string dna result Mutant
     */
    @Test
    void verifyIsMutant() {
        String dna = "ATGCGA;CAGTGC;TTATGT;AGAAGG;CCCCTA;TCACTG";
        boolean rta = checked.isMutant(dna);
        assertTrue(rta);
    }
    /**
     * Test check string dna result Human
     */
    @Test
    void verifyIsHuman() {
        String dna =  "ATGCGA;CTGTAC;TTATGT;AGAAGG;CCGCTA;TCACTG";
        boolean rta = checked.isMutant(dna);
        assertFalse(rta);
    }
    @Test
    void verifyIsHumanNull() {
        boolean rta = checked.isMutant(null);
        assertFalse(rta);
    }
    @Test
    void verifyIsHumanNNull() {
        String dna =  "";
        boolean rta = checked.isMutant(dna);
        assertFalse(rta);
    }
}
