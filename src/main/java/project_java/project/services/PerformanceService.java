package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.dto.PerformanceRequest;
import project_java.project.models.Performance;
import project_java.project.repositories.PerformanceRepository;

import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public List<Performance> getPerformances(){

        return performanceRepository.getPerformances();
    }

    public Performance addPerformance(Performance performance){

        return performanceRepository.addPerformance(performance);
    }

    public List <Performance> getPerformancesByCategory(String category) {
        return performanceRepository.getPerformancesByCategoryName(category);
    }
    public List <Performance> getPerformancesByRoom(String room) {
        return performanceRepository.getPerformancesByRoomName(room);
    }

    public List<Performance> deletePerformanceById(int id){

        return performanceRepository.deletePerformanceById(id);
    }
}
