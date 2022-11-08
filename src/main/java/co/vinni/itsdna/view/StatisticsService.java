package co.vinni.itsdna.view;

import co.vinni.itsdna.model.Statistics;
import co.vinni.itsdna.model.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsRepository staticticsRepository;

    public List<Statistics> getAll(){
        return staticticsRepository.findAll();
    }


    public boolean getExistsById(Long id){
        return staticticsRepository.existsById(id);
    }
}
