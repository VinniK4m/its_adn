package co.vinni.itsdna.controller;


import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.view.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/")
    public List<Statistics> getAll(){
        return statisticsService.getAll();
    }
    @GetMapping("/{id}")
    public List<Statistics> getById(Long id){
        return statisticsService.getAll();
    }

}
