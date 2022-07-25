package project_java.project.mapper;


import org.springframework.stereotype.Component;
import project_java.project.dto.PerformanceRequest;
import project_java.project.models.Performance;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Component
public class PerformanceMapper {
    public Performance performanceRequestToPerformance(PerformanceRequest performanceRequest)throws ParseException {
        return new Performance(performanceRequest.getName(), performanceRequest.getTicketPrice(),
                new java.util.Date(new SimpleDateFormat("dd/MM/YYYY-HH:mm:ss").parse(performanceRequest.getStart()).getTime()),
                new java.util.Date(new SimpleDateFormat("dd/MM/YYYY-HH:mm:ss").parse(performanceRequest.getEnd()).getTime()),
                performanceRequest.getCategoryId());
    }
}
