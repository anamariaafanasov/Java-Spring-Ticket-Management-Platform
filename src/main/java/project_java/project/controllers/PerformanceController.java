package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.PerformanceRequest;
import project_java.project.mapper.PerformanceMapper;
import project_java.project.models.Performance;
import project_java.project.services.PerformanceService;


import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    private PerformanceService performanceService;

    private PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService, PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @GetMapping("/get")
    public List<Performance> getPerformances() {
        return performanceService.getPerformances();
    }


    @GetMapping("/byCategory")
    public  ResponseEntity<?> getPerformancesByCategory(@RequestParam String category) {
            return ResponseEntity.ok().body(performanceService.getPerformancesByCategory(category));
    }

    @GetMapping("/byRoom")
    public  ResponseEntity<?> getPerformancesByRoom(@RequestParam String room) {
        return ResponseEntity.ok().body(performanceService.getPerformancesByRoom(room));
    }



    @PostMapping
    public ResponseEntity<?> addPerformance(@Valid @RequestBody PerformanceRequest performanceRequest) throws ParseException {
            Performance performance = performanceMapper.performanceRequestToPerformance(performanceRequest);
            Performance p = performanceService.addPerformance(performance);
            return ResponseEntity
                    .created(URI.create("/performances/" + performanceRequest.getName() + performanceRequest.getTicketPrice() + performanceRequest.getStart() + performanceRequest.getEnd() + performanceRequest.getCategoryId())).body(p);



    }

    @DeleteMapping("/delete")
    public List<Performance> deletePerformanceById(@RequestParam int id) {
        return performanceService.deletePerformanceById(id);
    }


}
