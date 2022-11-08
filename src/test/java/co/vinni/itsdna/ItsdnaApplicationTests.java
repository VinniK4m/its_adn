package co.vinni.itsdna;

import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.view.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ItsdnaApplicationTests {
    @Autowired
    StatisticsService statisticsService;

    @Test
    void contextLoads() {
        assertEquals(2,2);
    }

    @Test
    void contextLoads1() {
        List<Statistics> statistics = statisticsService.getAll();
        assertEquals(0,statistics.size());
    }


}
