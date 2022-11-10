package co.vinni.itsdna;


import co.vinni.itsdna.controller.DnaController;
import co.vinni.itsdna.controller.StatisticsController;
import co.vinni.itsdna.dto.DnaDto;
import co.vinni.itsdna.model.Dna;
import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.view.DnaImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DnaControllerTest {


    @Autowired
    private DnaController controller;
    @Autowired
    private StatisticsController statisticsController;

    @Autowired
    private DnaImplementation dnaService;


    private final DnaController  checked = new DnaController();
    DnaControllerTest(){


    }

    @Test
    void verifyNull() {
        String version = dnaService.getVersion();
        assertEquals("", version);
    }


    @Test
    void buildStats() {
        Statistics stats = dnaService.getStatistics();
        assertNotNull(stats.getCountHumanDna());
    }


    @Test
    void isMutant() {
        List<Dna> stats = dnaService.getAllDna();
        assertNotNull(stats);
    }
    @Test
    void isMutantController() {

        Object rta = controller.isMutant(null);
        assertNotNull(rta);
    }

    @Test
    void versionController() {

        Object rta = controller.version();
        assertNotNull(rta);
    }
    @Test
    void isMutantMy() {
        List<Dna> stats = dnaService.getAllDna();
        assertEquals(1, stats.size());
    }
    @Test
    void isMutantDnaController() {
        DnaDto dta = new DnaDto();
        Object rta = controller.isMutant(dta);
        assertNotNull(rta);
    }
    @Test
    void isMutantDnaOController() {
        DnaDto dta = new DnaDto(1, "", "");
        Object rta = controller.isMutant(dta);
        System.out.println(rta);
        assertNotNull(rta);
    }

    @Test
    void versionEController() {

        Object rta = controller.version();
        Object rta1 = controller.version();
        assertEquals(rta, rta1);
    }
    @Test
    void staticGetAllController() {

        Object rta = statisticsController.getAll();
        assertNotNull(rta);
    }

    @Test
    void getByIdController() {

        List<Statistics> rta = statisticsController.getById(1L);
        assertEquals(0, rta.size());
    }
    @Test
    void getByIdNullController() {

        Object rta = statisticsController.getById(1L);
        assertNotNull(rta);
    }

}
