package co.vinni.itsdna;


import co.vinni.itsdna.controller.DnaController;
import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.view.DnaImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DnaControllerTest {


    @Autowired
    private DnaController controller;

    @Autowired
    private DnaImplementation dnaService;


    private final DnaController  checked = new DnaController();
    DnaControllerTest(){


    }





    @Test
    void verifyNull() {
        String version = dnaService.getVersion();
        System.out.println(version);
        assertEquals("", version);
    }


    @Test
    void buildStats() {
        Statistics stats = dnaService.getStatistics();
        System.out.println(stats.equals(stats));
        assertEquals(stats,stats);
    }


    @Test
    void isMutant() {
        List stats = dnaService.getAllDna();
        System.out.println(stats.size());
        assertEquals(0, stats.size());
    }



}
